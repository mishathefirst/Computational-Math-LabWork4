package app;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

class ListOfFunctions {

    double getFirstFunction(double x){
        return (sin(x));
    }

    String getFirstFunctionAsString(){
        return "y = sin(x)";
    }

    double getSecondFunction(double x){
        return (cos(x));
    }

    String getSecondFunctionAsString(){
        return "y = cos(x)";
    }

    double getThirdFunction(double x){
        return (pow(x, 2));
    }

    String getThirdFunctionAsString(){
        return "y = x^2";
    }

    double getForthFunction(double x){
        return (pow(x, 3) + 5);
    }

    String getForthFunctionAsString(){
        return "y = x^3 + 5";
    }

    double getFifthFunction(double x){
        return (pow(x, 2)+ x + 5);
    }

    String getFifthFunctionAsString(){
        return "y = x^2 + x + 5";
    }

}
