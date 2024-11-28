package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //  Mouse Hover on the “ELECTRONICS” Tab
        mouseToElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));
        //  Mouse Hover on the “Cell phones” and click
        mouseHoverAndClick(By.partialLinkText("Cell"));
        //  Verify the text “Cell phones
        assertMethod("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

    }


    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        //   Mouse Hover on the “ELECTRONICS” Tab
        mouseToElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']"));
        //  Mouse Hover on the “Cell phones” and click
        mouseHoverAndClick(By.partialLinkText("Cell"));

        //  Verify the text “Cell phones”
        assertMethod("Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        // Select View as option ‘List’
        selectFromDropDown(By.xpath("//select[@id='products-viewmode']"), "List");

        //  Click on the product name “Smartphone” link
        clickOnElement(By.xpath("//a[normalize-space()='Smartphone']"));

        //  Verify the text “Smartphone”
        assertMethod("Smartphone", By.xpath("//h1[normalize-space()='Smartphone']"));

        //  Verify the price “100.00”
        assertMethod("100.00", By.xpath("(//span[@class='price-value-43'])[1]"));

        //  Change the quantity to 2
        WebElement qty = driver.findElement(By.xpath("(//input[@id='addtocart_43_EnteredQuantity'])[1]"));
        qty.clear();
        qty.sendKeys("2");

        // Click on the “Add to cart” tab
        clickOnElement(By.xpath("(//input[@id='add-to-cart-button-43'])[1]"));

        //  Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertMethod("The product has been added to your shopping cart", By.xpath("(//p[@class='content'])[1]"));

        //  After that close the bar by clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));

        //  Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        mouseToElement(By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']"));

        //  Verify the message "Shopping cart"
        assertMethod("Shopping cart", By.xpath("//span[normalize-space()='Shopping cart']"));

        //  Verify the quantity is 2
        // assertMethod("2", By.cssSelector(".qty-input"));

        //  Verify the Total “200.00”
        //  assertMethod("200.00", By.xpath("//span[@class='product-price order-total']//strong[contains(text(),'200.00')]"));
        //  click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  Click on the “Checkout” button
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //  Verify the Text “Welcome, Please Sign In!”
        assertMethod("Welcome, Please Sign In!", By.tagName("h1"));

        //  Click on the “Register” tab
        clickOnElement(By.xpath("//input[@value='Register']"));

        //  Verify the text “Register”
        assertMethod("Register", By.tagName("h1"));

        //  Select the Male radio button
        clickOnElement(By.xpath("//input[@id='gender-male']"));

        // Enter the First name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Hardik");

        //  Enter the Last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");

        //  Enter the Email
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("hp800@gmail.com");

        //  Enter the Password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("678900");

        //  Enter the Confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("678900");

        // Click on the “Register” button
        clickOnElement(By.xpath("//input[@id='register-button']"));

        // Verify the message “Your registration completed”
        assertMethod("Your registration completed", By.xpath("//div[@class='result']"));

        //  Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //  Verify the text “Shopping cart”
        assertMethod("Shopping cart", By.xpath("//h1[normalize-space()='Shopping cart']"));

        //  click on the checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //  Click on the “Checkout”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //  Select the Country “United Kingdom” using the select class
        selectFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");

        //  Enter the city
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("London");

        //  Enter the Address1
        driver.findElement(By.xpath("(//input[@id='BillingNewAddress_Address1'])[1]")).sendKeys("20 Kenton Street");

        //  Enter the Zip/Postal code
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("KN2 DG3");

        //  Enter the Phone number
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("07123456677");

        //  Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Billing.save()']"));

        //  Click on the “Continue” button
        clickOnElement(By.xpath("//input[@onclick='Shipping.save()']"));

        //  Click on the Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("(//input[@id='shippingoption_2'])[1]"));

        //  Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 shipping-method-next-step-button'])[1]"));

        // Select the Radio Button “Credit Card”
        clickOnElement(By.xpath("(//input[@id='paymentmethod_2'])[1]"));

        //  Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 payment-method-next-step-button'])[1]"));

        //  Select the “Visa” From Select credit card dropdown
        selectFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //  Enter the Cardholder's name
        driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("Hardik P");

        //   Enter the Card number
        driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("098765123487651");

        //  Select the Expiration date using the select class
        selectFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2029");

        //  Enter the Card code
        driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("786");

        //  Click on the “Continue” button
        clickOnElement(By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]"));

        // Verify the “Payment Method” is “Credit Card”
        assertMethod("Credit Card", By.xpath("//li[@class='payment-method']"));

        // Verify the “Shipping Method” is “2nd Day Air”
        assertMethod("2nd Day Air", By.xpath("//li[@class='shipping-method']"));

        //  Verify the Total is “200.00”
        assertMethod("200.00", By.cssSelector("span[class='product-price order-total'] strong"));

        // Click on the “Confirm” button
        clickOnElement(By.xpath("//input[@value='Confirm']"));

        //  Verify the Text “Thank You”
        assertMethod("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

        // Verify the message “Your order has been successfully processed!”
        assertMethod("Your order has been successfully processed!", By.tagName("strong"));

        //  Click on the “Continue” button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //  Verify the text “Welcome to our store”
        assertMethod("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"));

        // Click on the “Logout” link
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));

        //  Verify the URL is “https://demowebshop.tricentis.com/”
        Assert.assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}