# Read Me First
This is a kata for practicing IntelliJ Shortcuts.  
It is not intended to be a meaningful service that accomplishes anything useful.
Run tests before start and run them every few minutes to confirm refactor worked.

# Getting Started

### Shortcuts

* Extract Variable - Ctrl+Alt+V (Windows) or Command+Option+V (Mac)
* Extract Method - Ctrl+Alt+M (Windows) or Command+Option+M (Mac)
* Inline - Ctrl+Alt+N (Windows) or Command+Option+N (MAC)
* Extract Parameter - Ctrl+Alt+P (Windows) or Command+Option+P (Mac)
* Extract Field - Ctrl+Alt+F (Windows) or Command+Option+F (Mac)
* Check for refactoring suggestions - Alt+Enter (Windows) or Control+Enter (Mac)
* Generate Test method - Alt+Insert (Windows) or Command+N (Mac)
* Move line or whole method up - Ctrl+Shift+Up Arrow (Windows) or Command+Shift+Up Arrow (Mac)
* Copy whole line - Have cursor on line with nothing highlighted and Ctrl+C or Command+C
* Go to method signature - Ctrl+click (Windows) or Command+click (Mac)
* Return to previous place/class - Ctrl+Alt+Left Arrow (Windows) or Command+Option+Left Arrow (Mac)

### Practice Steps

Extract Variables in LegacyService
* Extract request.vin as a variable (both instances of it) and name it "vin"
* Extract "This vin is not valid" as a variable (both instances of it) and name it "errorMessage"
* Extract "1" as a variable named "prefix"
* Extract "Invalid" as a variable named "invalidVinMessage"
* Inline all four extracted variables

Extract Methods in LegacyService
* Extract ```!identificationNo.startsWith("1")``` to a method named "isInvalid(identificationNo)"
* Extract ```LegacyResponse.builder().id(identificationNo).incomingRequest(request).build();``` to a method named "buildResponse(request, identificationNo)"
  * Notice that the builder in the first If statement did not get extracted
  * Inline the "buildResponse" method 
  * Change the builder so the incomingRequest is set first
  * Extract the method again and select the option to extract the second method also
* Extract ```throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");``` to a method named "getLegacyResponse"
  * Select option to extract the second method also
  * Notice how the first method extracted has ```return``` in front of it.  Delete the ```return``` and run the tests.
* Inline "response" variable
* Inline "getLegacyResponse" method
* Inline "isInvalid" method
* Checkout code to roll back

Extract Parameter in LegacyService
* Extract ```throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This vin is not valid");``` to a method named "getLegacyResponse"
* Extract "This vin is not valid" as a parameter to the "getLegacyResponse" method

* Extract Field
* Invert If condition with IntelliJ refactoring suggestions
* Generate Test methods

