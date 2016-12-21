# gordon-ramsey-prob
A service that takes a text file as input and calculates maximum achievable satisfaction value given all inputs

Approach:
---------------
1. Set up a  spring boot application
2. Created an api which reads a text file from classpath and calculates the satisfaction index.
3. Written test case without placing the data file in the classpath or with empty file, it gives exception.
4. Written first test case when my code to calculate maximum satisfaction value doesn't handle invalid parameter(say I pass invalid no of dishes or empty satisfaction value list), then the test fails. Then I wrote the validation and re-run the test, it passed.
5. Written second test case where inputs are valid, but the code to actually determine correct satisfaction value was not present.Test failed. Written the actual implementation and reran the code. It failed again few more times due to some incorrect implementation.Finally resolved that and the test passed.
6. One more test case where the time required to eat dish with maximum satisfaction value is more that the alloted time. But that test failed. Later modified code so, only the lower satisfaction value dishes were taken into account to calculate satisfaction value in such cases.
7. The maximum satisfaction value calculated for the given data file is :: 2493893
