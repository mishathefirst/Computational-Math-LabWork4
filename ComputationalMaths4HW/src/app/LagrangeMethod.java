package app;

class LagrangeMethod {

    Result solve(double x, int numberOfPoints, double[] xArray, double[] yArray){

        //TODO: numberOfPoints is bigger than the number of intervals (+1)

        double[] lArray = new double[numberOfPoints];
        double numerator, denominator, LnFunctionValue = 0;


        for (int i = 0; i < numberOfPoints; i++){
            numerator = 1;
            denominator = 1;
            for(int k = 0; k < numberOfPoints; k++){
                if (xArray[i] != xArray[k]) {
                    numerator *= (x - xArray[k]);
                    denominator *= (xArray[i] - xArray[k]);
                }
            }
            lArray[i] = numerator / denominator;
            LnFunctionValue += lArray[i] * yArray[i];
        }


        return new Result(LnFunctionValue);
    }
}
