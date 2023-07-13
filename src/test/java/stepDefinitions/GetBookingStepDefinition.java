package stepDefinitions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.When;
import stepDefinationsImpl.BookingsImpl;

import static stepDefinitions.CreateBookingStepDefinition.report;

public class GetBookingStepDefinition  extends  AbstractStepDefinition{
    BookingsImpl bookingImpl = new BookingsImpl();

    @When("client retrieve the valid booking id")
    public void clientRetrieveTheValidBookingId() {
        test = report.startTest("reterieve bookings id's");
        bookingImpl.getBookingsById(bookingId);
        test.log(LogStatus.INFO, "verified retrieve booking Id's");


    }

    @When("client retrieve with invalid booking id")
    public void clientRetrieveWithInvalidBookingId() {
        test = report.startTest("inValid bookings id's");
        bookingImpl.getBookingsById(887636535);
        test.log(LogStatus.INFO, "error message displayed");

    }
}
