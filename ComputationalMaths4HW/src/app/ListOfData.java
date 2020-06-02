package app;

class ListOfData {

    double[] getFirstDataSet(){
        double[] firstDataSet = new double[5];
        for (int i = 0; i < 5; i++){
            firstDataSet[i] = i * (Math.PI) / 2;
        }
        //TODO: remove
        for (int i = 0; i < 5; i++){
            System.out.println("Ix: " + firstDataSet[i]);
        }
        return firstDataSet;
    }

    String getFirstDataSetAsString(){
        return "interval: from 0 to 2Pi; \n number of points: 5";
    }

    double[] getSecondDataSet(){
        double[] secondDataSet = new double[11];
        for (int i = 0; i < 11; i++){
            secondDataSet[i] = i * (Math.PI) / 5;
        }
        return secondDataSet;
    }

    String getSecondDataSetAsString(){
        return "interval: from 0 to 2Pi; \n number of points: 11";
    }


    double[] getThirdDataSet(){
        double[] thirdDataSet = new double[11];
        for (int i = 0; i < 11; i++){
            thirdDataSet[i] = i * (Math.PI) / 5;
        }
        return thirdDataSet;
    }

    String getThirdDataSetAsString(){
        return "interval: from 0 to 2Pi; \n number of points: 11; \n First value of Y is set to -5 " +
                "\n in the table of points " +
                "\n for the interpolated function";
    }

    double[] getForthDataSet(){
        double[] forthDataSet = new double[11];
        for (int i = 0; i < 11; i++){
            forthDataSet[i] = i * (Math.PI) * 5;
        }
        return forthDataSet;
    }

    String getForthDataSetAsString(){
        return "interval: from 0 to 50Pi; \n number of points: 11";
    }


    double[] getFifthDataSet(){
        double[] fifthDataSet = new double[11];
        for (int i = 0; i < 11; i++){
            fifthDataSet[i] = -4 + i * 0.9;
        }
        return fifthDataSet;
    }

    String getFifthDataSetAsString(){
        return "interval: from -4 to 5; \n number of points: 11";
    }

    double getLowerLimit(int selectedData){
        switch(selectedData){
            case(1): return 0;
            case(2): return 0;
            case(3): return 0;
            case(4): return 0;
            case(5): return -4;
            default: return 0;
        }
    }

    double getUpperLimit(int selectedData){
        switch(selectedData){
            case(1): return (Math.PI * 2);
            case(2): return (Math.PI * 2);
            case(3): return (Math.PI * 2);
            case(4): return (Math.PI * 50);
            case(5): return (5);
            default: return 0;
        }
    }


    double getStep(int selectedData){
        switch(selectedData){
            case(1): return (Math.PI / 10);
            case(2): return (Math.PI / 10);
            case(3): return (Math.PI / 10);
            case(4): return (Math.PI);
            case(5): return (0.9);
            default: return Math.PI / 2;
        }
    }


    int getNumberOfPoints(int numberOfPoints){
        switch(numberOfPoints){
            case(1): return 5;
            case(2): return 11;
            case(3): return 11;
            case(4): return 11;
            case(5): return 11;
            default: return 5;
        }
    }

}
