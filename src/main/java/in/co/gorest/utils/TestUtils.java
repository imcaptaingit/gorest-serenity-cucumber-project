package in.co.gorest.utils;

import java.util.Random;

/**
 * Author - Sarvat Shaikh
 * Project Name: gorest-serenity-cucumber-project
 */

public class TestUtils {

	public static String getRandomValue(){
		Random random = new Random();
		int randomInt = random.nextInt(100000);
		return Integer.toString(randomInt);
	}
}
