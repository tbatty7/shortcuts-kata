# Read Me First
This is a kata for practicing IntelliJ Shortcuts.  
It is not intended to be a meaningful service that accomplishes anything useful.
Run tests before start and run them every few minutes to confirm refactor worked.

## Shortcuts

* Extract Variable - Ctrl+Alt+V (Windows) or Command+Option+V (Mac)
* Extract Method - Ctrl+Alt+M (Windows) or Command+Option+M (Mac)
* Inline Variable or Method - Ctrl+Alt+N (Windows) or Command+Option+N (MAC)
* Extract Parameter - Ctrl+Alt+P (Windows) or Command+Option+P (Mac)
* Extract Field - Ctrl+Alt+F (Windows) or Command+Option+F (Mac)
* Rename method/variable/field/class - Shift+F6 (Windows and Mac)
* Check for refactoring suggestions - Alt+Enter (Windows) or Control+Enter (Mac)
  * Invert If statement
  * Safe Delete unused parameter
* Generate or go to Test Class - Ctrl+Shift+T (Windows) or Command+Shift+T (Mac)
* Generate Test method - Alt+Insert (Windows) or Command+N (Mac)
* Move method to another class - F6 (Windows and Mac)
* Move line or whole method up - Ctrl+Shift+Up Arrow (Windows) or Command+Shift+Up Arrow (Mac)
* Copy whole line - Have cursor on line with nothing highlighted and Ctrl+C or Command+C
* Go to method signature - Ctrl+click (Windows) or Command+click (Mac)
* Return to previous place/class - Ctrl+Alt+Left Arrow (Windows) or Command+Option+Left Arrow (Mac)
* Expand selection to include the whole word/method/line - Ctrl+W (Windows) or Command+W (Mac)

## Practice Steps

#### Extract Variables in LegacyService
* Extract "1" as a variable named "prefix"
* Extract "Invalid" as a variable named "invalidIdMessage"
* Extract request.vin as a variable (both instances of it) and name it "vin"
* Extract "This vin is not valid" as a variable (both instances of it) and name it "errorMessage"
* Inline all four extracted variables

#### Extract Methods in LegacyService
* Extract ```!identificationNo.startsWith("1")``` to a method named "isInvalid(identificationNo)"
* Extract ```LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();``` to a method named "buildResponse(request, identificationNo)"
  * Notice that the builder in the first If statement did not get extracted
  * Inline the "buildResponse" method 
  * Change the builder so the incomingRequest is set first
  * Extract the method again and select the option to extract the second method also
* Extract ```throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");``` to a method named "getLegacyResponse()"
  * Select option to extract the second method also
  * Notice how the first method extracted has ```return``` in front of it.  Delete the ```return``` and run the tests.
* Extract this if statement ```if (request.vin.contains("test")) {
                                           getLegacyResponse();
                                       }``` to a method named "validate(request)" and then inline it again
* Inline "response" variable
* Inline "getLegacyResponse" method
* Inline "isInvalid" method
* Checkout code to roll back

#### Extract Parameter in LegacyService
* Extract ```throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");``` to a method named "getLegacyResponse"
* Extract "This vin is not valid" as a parameter to the "getLegacyResponse" method.  Name the parameter "errorMessage"
* Inline the parameter
* Extract "Invalid" as a parameter named "invalidIdMessage"
* Inline the parameter
* Extract "1" as a parameter named "prefix"
* Inline the parameter
* Extract the request.getName() in the "nameChecker(request)" method as a parameter named "name"
  * Notice how the request parameter was replaced.
* Checkout code to roll back

#### Extract Field in LegacyService
* Extract "1" as a field named "prefix"
  * Notice the checkbox that allows you to initialize in different places.  Initialize in field
* Extract "Invalid" as a field named "invalidVinMessage"
  * Initialize in Constructor
  * Extract it as parameter in Constructor
  * Add `@Value("${message}")` in front of it in method signature
  * Notice how the tests changed
* Extract "This vin is not valid" as a field and name it "errorMessage"
  * Initialize in field
  * Check box to extract both instances of it
* Extract request.vin as a field and name it "vin"
  * Extract both instances of it
  * Notice the field is initialized in the method without giving you an option
* Inline the "vin" field.  
  * Notice that IntelliJ is unable to inline that because of the method level initialization
  * Use Ctrl+Z to undo it
* Inline the rest of the extracted fields
* Checkout code to roll back

#### Combination Shortcuts to Invert If Condition in LegacyService
* Using the shortcut, move the last two if statements to the top of the method
* Inline the "response" variable
* Invert If condition of ```
if (!identificationNo.startsWith("1")) {
                                        return LegacyResponse.builder().incomingRequest(null).id("Invalid").build();
                                    }
                                    ``` with IntelliJ refactoring suggestions
* Checkout code to roll back

#### Moving Methods to Another Class and Generating Tests
* Move nameChecker method to the LegacyRequest class
    * Notice that the tests are unchanged
* Extract the bottom two if statments as two seperate methods
* Move both of them to the LegacyRequest class.
* Create test class for LegacyRequest class
* Create test
* Create BeforeEach method (setup method)
* Delete the test class and checkout code to roll back

#### Extracting a method to a new Class
* Extract the initializing of the response variable to a method named returnResponse
    * `LegacyResponse response = LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();`
* Inside the new method, on the first line, type `new LegacyClient();`
* Use shortcut to create class from that constructor call
* In the returnResponse method, extract `new LegacyClient()` as a parameter
* Move method to LegacyClient class
    * The LegacyClient is now being initialized in the convert method.
* In convert method, extract the `new LegacyClient()` to a field
    * Initialize it in the constructor
* In the constructor, extract the `new LegacyClient()` as a parameter
    * To make it compile, add the `@Service` annotation to the LegacyClient
    * At this point, you would want to add a mock to the tests of LegacyService and create a new test class for the LegacyClient