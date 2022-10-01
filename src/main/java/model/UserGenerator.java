package model;

import com.github.javafaker.Faker;

public class UserGenerator {

  static Faker faker = new Faker();
  private static String randomName = faker.name().username();
  private static String randomEmail = randomName + "@random123.mail.ru";

  public static User getRandom() {
    return new User(randomName, randomEmail, "PasSwOrD");
  }

  public static User getRandomWithIncorrectPassword() {
    return new User(randomName, randomEmail, "PasSw");
  }
}
