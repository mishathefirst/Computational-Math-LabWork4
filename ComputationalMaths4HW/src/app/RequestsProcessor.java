package app;

public class RequestsProcessor {
    private LagrangeMethod lagrangeMethod = new LagrangeMethod();
    private ListOfData listOfData = new ListOfData();
    private ListOfFunctions listOfFunctions = new ListOfFunctions();
    private double x;
    private int selectedFunction, selectedData, numberOfPoints;
    private double[] xArray, yArray;

    /*
    Result analyseFirstFunction(double x, int selectedData){
        selectedFunction = 1;
        this.x = x;
        this.selectedData = selectedData;
        this.numberOfPoints = listOfData.getNumberOfPoints(selectedData);
        this.xArray = listOfData.getFirstDataSet();
        for(int i = 0; i < numberOfPoints; i++){
            this.yArray[i] = listOfFunctions.getFirstFunction(xArray[i]);
        }
        return lagrangeMethod.solve(x, numberOfPoints, xArray, yArray);
    }


    Result analyseSecondFunction(double x, int selectedData){
        selectedFunction = 2;
        this.x = x;
        this.selectedData = selectedData;
        this.numberOfPoints = listOfData.getNumberOfPoints(selectedData);
        this.xArray = listOfData.getSecondDataSet();
        for(int i = 0; i < numberOfPoints; i++){
            this.yArray[i] = listOfFunctions.getSecondFunction(xArray[i]);
        }
        return lagrangeMethod.solve(x, numberOfPoints, xArray, yArray);
    }


    Result analyseThirdFunction(double x, int selectedData){
        selectedFunction = 3;
        this.x = x;
        this.selectedData = selectedData;
        this.numberOfPoints = listOfData.getNumberOfPoints(selectedData);
        this.xArray = listOfData.getThirdDataSet();
        for(int i = 0; i < numberOfPoints; i++){
            this.yArray[i] = listOfFunctions.getThirdFunction(xArray[i]);
        }
        return lagrangeMethod.solve(x, numberOfPoints, xArray, yArray);
    }


    Result analyseForthFunction(double x, int selectedData){
        selectedFunction = 4;
        this.x = x;
        this.selectedData = selectedData;
        this.numberOfPoints = listOfData.getNumberOfPoints(selectedData);
        this.xArray = listOfData.getForthDataSet();
        for(int i = 0; i < numberOfPoints; i++){
            this.yArray[i] = listOfFunctions.getThirdFunction(xArray[i]);
        }
        return lagrangeMethod.solve(x, numberOfPoints, xArray, yArray);
    }
    */

    Result analyseFunction(double x, int selectedFunction, int selectedData){
        this.selectedFunction = selectedFunction;
        this.x = x;
        this.selectedData = selectedData;
        this.numberOfPoints = listOfData.getNumberOfPoints(selectedData);
        switch(selectedData){
            case(1): this.xArray = listOfData.getFirstDataSet();
            case(2): this.xArray = listOfData.getSecondDataSet();
            case(3): this.xArray = listOfData.getThirdDataSet();
            case(4): this.xArray = listOfData.getForthDataSet();
            case(5): this.xArray = listOfData.getFifthDataSet();
        }

        switch(selectedFunction){
            case(1): {
                for(int i = 0; i < numberOfPoints; i++){
                    this.yArray[i] = listOfFunctions.getFirstFunction(xArray[i]);
                }
            }
            case(2): {
                for(int i = 0; i < numberOfPoints; i++){
                    this.yArray[i] = listOfFunctions.getSecondFunction(xArray[i]);
                }
            }
            case(3): {
                for(int i = 0; i < numberOfPoints; i++){
                    this.yArray[i] = listOfFunctions.getThirdFunction(xArray[i]);
                }
            }
            case(4): {
                for(int i = 0; i < numberOfPoints; i++){
                    this.yArray[i] = listOfFunctions.getForthFunction(xArray[i]);
                }
            }
            case(5): {
                for(int i = 0; i < numberOfPoints; i++){
                    this.yArray[i] = listOfFunctions.getFifthFunction(xArray[i]);
                }
            }
        }

        return lagrangeMethod.solve(x, numberOfPoints, xArray, yArray);
    }

}
