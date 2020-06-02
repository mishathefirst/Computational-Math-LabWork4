package app;

public class RequestsProcessor {
    private LagrangeMethod lagrangeMethod = new LagrangeMethod();
    private ListOfData listOfData = new ListOfData();
    private ListOfFunctions listOfFunctions = new ListOfFunctions();
    private double x;
    private int selectedFunction, selectedData, numberOfPoints;
    //TODO: warning: hard-code value for allocating more elements than needed to avoid NPE
    private double[] xArray, yArray = new double[20];

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
        /*
        switch(selectedData){
            case(1): this.xArray = listOfData.getFirstDataSet();
            case(2): this.xArray = listOfData.getSecondDataSet();
            case(3): this.xArray = listOfData.getThirdDataSet();
            case(4): this.xArray = listOfData.getForthDataSet();
            case(5): this.xArray = listOfData.getFifthDataSet();
        }
        */
        if (selectedData == 1){
            this.xArray = listOfData.getFirstDataSet();
        }
        else if(selectedData == 2){
            this.xArray = listOfData.getSecondDataSet();
        }
        else if (selectedData == 3){
            this.xArray = listOfData.getThirdDataSet();
        }
        else if (selectedData == 4){
            this.xArray = listOfData.getForthDataSet();
        }
        else if (selectedData == 5){
            this.xArray = listOfData.getFifthDataSet();
        }

        /*
        switch(selectedFunction){
            case(1): {
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getFirstFunction(xArray[i]);
                }
            }
            case(2): {
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getSecondFunction(xArray[i]);
                }
            }
            case(3): {
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getThirdFunction(xArray[i]);
                }
            }
            case(4): {
                yArray[0] = -5;
                for(int i = 1; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getForthFunction(xArray[i]);
                }
            }
            case(5): {
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getFifthFunction(xArray[i]);
                }
            }
        }
        */



        if (selectedFunction == 1){
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getFirstFunction(xArray[i]);
                }
            }
            else if (selectedFunction == 2){
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getSecondFunction(xArray[i]);
                }
            }
            else if (selectedFunction == 3){
            yArray[0] = -5;
                for(int i = 1; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getThirdFunction(xArray[i]);
                }
            }
            else if (selectedFunction == 4){
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getForthFunction(xArray[i]);
                }
            }
            else if (selectedFunction == 5){
                for(int i = 0; i < numberOfPoints; i++){
                    yArray[i] = listOfFunctions.getFifthFunction(xArray[i]);
                }
            }


        //TODO: remove
        for (int i = 0; i < numberOfPoints; i++){
            System.out.println("x: " + xArray[i]);
            System.out.println("y: " + yArray[i]);
        }

        return lagrangeMethod.solve(x, numberOfPoints, xArray, yArray);
    }

}
