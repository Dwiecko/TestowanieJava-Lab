Narrative:
In order to show calculator operations
As a Dawid Wiecko
I want to use BDD for calculator

Scenario:  Two numbers sub operations
Given new calculator
When I sub 4 and 4
Then the result is 0

Scenario:  Second Two numbers sub operations
Given new calculator
When I sub 4 and 4
Then the result becomes 0

Scenario:  Two numbers div operations
Given new calculator
When I div 4 and 4
Then I receive 1

Scenario:  Two numbers multiply operations
Given new calculator
When I multiply 1 and 5
Then I receive 5

Scenario:  Two numbers equality
Given new calculator
When I pass 4 and 4
Then I receive true for 4 and 4

Scenario:  Test if one number is less than another
Given new calculator
When I pass 1 and 4
Then I receive true for 1 and 4

Scenario:  Two numbers less operations
Given new calculator
When I pass for less $firstnumber $secondnumber
Then I receive true

Examples:
|firstnumber|secondnumber|
|100|200|

Scenario:  Two numbers add operations
Given new calculator
When I add $firsttoaddnumber $secondtoaddnumber
Then What I receive is $result

Examples:
|firsttoaddnumber|secondtoaddnumber|result|
|1|2|3|
|1|2|4|
|3|4|7|