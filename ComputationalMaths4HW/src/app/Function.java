package app;

class Function {

    private ListOfFunctions listOfFunctions = new ListOfFunctions();

    double getValue(int selectedEquation, int selectedData, double x) {
        switch(selectedEquation){
            case(1): return listOfFunctions.getFirstFunction(x);
            case(2): return listOfFunctions.getSecondFunction(x);
            case(3): return listOfFunctions.getThirdFunction(x);
            case(4): return listOfFunctions.getForthFunction(x);
            case(5): return listOfFunctions.getFifthFunction(x);
            default: return 0;
        }
    }
}
