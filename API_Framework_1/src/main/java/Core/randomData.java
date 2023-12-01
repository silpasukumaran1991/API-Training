package Core;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class randomData {
public String getRandomEmail()
{
	FakeValuesService fakeValueService = new FakeValuesService(new Locale("en-GB"), new RandomService());
	String email = fakeValueService.bothify("????##@gmail.com");
	System.out.println(email);
	return email;
}

//Assignmnet 
/*public String getRandomMobNo()
{
	FakeValuesService fakeValueService = new FakeValuesService(new Locale("en-GB"), new RandomService();
	String email = fakeValueService.regexify("+91");
	System.out.println(email);
	return email;
}*/

public String getRandomAddress()
{
	Faker faker = new Faker ();
	String address = faker.address().fullAddress();
	System.out.println(address);
	return address;
}

}
