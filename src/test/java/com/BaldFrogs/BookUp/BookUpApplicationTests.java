package com.BaldFrogs.BookUp;

import com.BaldFrogs.BookUp.Model.Listing;
import com.BaldFrogs.BookUp.Database.Database;
import com.BaldFrogs.BookUp.Model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class BookUpApplicationTests {

	@Test
	void testListingModel()
	{
		Listing l = new Listing("Sunnyvale", "2 bedroom", 55, 2, "884883");
		Assert.hasText(l.getLocation(), "Sunnyvale");
	}

	@Test
	void testUserModel()
	{
		User u = new User("Bob", "12345");
		Assert.hasText(u.getUsername(), "Bob");
	}
}
