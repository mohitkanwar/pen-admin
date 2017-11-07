package com.mk.spring.demo;

import com.mk.pen.user.User;
import com.mk.pen.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Component
class AppRunner implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookingService bookingService;
    private final UserService userService;
    public AppRunner(BookingService bookingService,UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> test1 = new ArrayList<>();
        test1.add("Alice");
        test1.add("Bob");
        test1.add("Carol");
        bookingService.book(test1);

        User user1 = new User(0,"Mohit", "Kanwar");
        User user2 = new User(0,"Shama", "Kanwar");
        userService.createUser(user1);
        userService.createUser(user2);
        Assert.isTrue(bookingService.findAllBookings().size() == 3,
                "First booking should work with no problem");
        logger.info("Alice, Bob and Carol have been booked");
        try {
            List<String> test2 = new ArrayList<>();
            test2.add("Chris");
            test2.add("Samuel");

            bookingService.book(test2);
        } catch (RuntimeException e) {
            logger.info("v--- The following exception is expect because 'Samuel' is too " +
                    "big for the DB ---v");
            logger.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            logger.info("So far, " + person + " is booked.");
        }
        logger.info("You shouldn't see Chris or Samuel. Samuel violated DB constraints, " +
                "and Chris was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "'Samuel' should have triggered a rollback");

        try {
            List<String> test3 = new ArrayList<>();
            test3.add("Buddy");
            test3.add(null);

            bookingService.book(test3);
        } catch (RuntimeException e) {
            logger.info("v--- The following exception is expect because null is not " +
                    "valid for the DB ---v");
            logger.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            logger.info("So far, " + person + " is booked.");
        }
        logger.info("You shouldn't see Buddy or null. null violated DB constraints, and " +
                "Buddy was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "'null' should have triggered a rollback");
    }

}