package lt.jurgitavis.persongenerator.service;

import java.text.DecimalFormat;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.jurgitavis.persongenerator.model.Gender;
import lt.jurgitavis.persongenerator.model.Person;
import lt.jurgitavis.persongenerator.repository.PersonNameRepository;

@Service
public class RandomPersonService {
    private final String LT_PHONE_PREFIX = "+3706";
    private final LocalDate MAX_BIRTHDATE = LocalDate.now().minusYears(6);
    private final LocalDate MIN_BIRTHDATE = LocalDate.now().minusYears(120);
    private final String EMAIL_DOMAIN = "@domain.lt";

    @Autowired
    private PersonNameRepository nameRepository;

    @Autowired
    private Map<String, String> surnameEndingPairsUnmarried;

    @Autowired
    private Map<String, String> surnameEndingPairsMarried;

    public List<Person> getListOfRandomPersons(int count) {
       return Stream.generate(this::getRandomPerson).limit(count).collect(Collectors.toList());
    }

    public Person getRandomPerson() {
        Person randomPerson = new Person();

        LocalDate birthdate = generateRandomBirthdate();
        Gender gender = getRandomGender();

        randomPerson.setName(nameRepository.getRandomName(gender));
        randomPerson.setSurname(getSurname(gender, birthdate));
        randomPerson.setBirthdate(birthdate);
        randomPerson.setPhoneNumber(generatePhoneNumber());
        randomPerson.setEmail(generateEmailAddress(randomPerson.getName(), randomPerson.getSurname()));

        return randomPerson;
    }

    private LocalDate generateRandomBirthdate() {
        long minDay = MIN_BIRTHDATE.toEpochDay();
        long maxDay = MAX_BIRTHDATE.toEpochDay();
        long randomDay = minDay + (long) (Math.random() * (maxDay - minDay));

        return LocalDate.ofEpochDay(randomDay);
    }

    private Gender getRandomGender() {
        if (new Random().nextBoolean()) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    private String getSurname(Gender gender, LocalDate birthdate) {
        int age = calculateAge(birthdate);
        String maleSurname = nameRepository.getRandomSurname();

        if (gender.equals(Gender.MALE)) {
            return maleSurname;
        } else if (age < 18) {
            return createNonMariedFemaleSurname(maleSurname);
        } else {
            if (new Random().nextBoolean()) {
                return createNonMariedFemaleSurname(maleSurname);
            } else {
                return createMariedFemaleSurname(maleSurname);
            }
        }
    }

    private int calculateAge(LocalDate birthdate) {
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    protected String createNonMariedFemaleSurname(String maleSurname) {
        for (String key : surnameEndingPairsUnmarried.keySet()) {
            if (maleSurname.endsWith(key)) {
                return replaceSurnameEnding(maleSurname, key, surnameEndingPairsUnmarried.get(key));
            }
        }
        return maleSurname;
    }

    protected String createMariedFemaleSurname(String maleSurname) {
        for (String key : surnameEndingPairsMarried.keySet()) {
            if (maleSurname.endsWith(key)) {
                return replaceSurnameEnding(maleSurname, key, surnameEndingPairsMarried.get(key));
            }
        }
        return maleSurname;
    }

    private String replaceSurnameEnding(String maleSurname, String ending, String replacement) {
        StringBuilder femaleSurname = new StringBuilder(maleSurname);
        int indexOfEnding = maleSurname.lastIndexOf(ending);

        return femaleSurname.replace(indexOfEnding, (indexOfEnding + ending.length()), replacement).toString();
    }

    // phone number of format +370 6XXXXXXX
    private String generatePhoneNumber() {
        return LT_PHONE_PREFIX + convertToFormatedString("0000000", new Random().nextInt(10000000));
    }

    private String convertToFormatedString(String format, int randomNumber) {
        DecimalFormat numberFormat = new DecimalFormat(format);
        return numberFormat.format(randomNumber);
    }

    private String generateEmailAddress(String name, String surname) {

        return Normalizer.normalize(name.toLowerCase(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .concat(".")
                .concat(Normalizer.normalize(surname.toLowerCase(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", ""))
                .concat(EMAIL_DOMAIN);
    }

}
