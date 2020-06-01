package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private int selectedFunction = 0, selectedData = 0;
    private double a, b, step, previousStep = 1, tmp;
    private double ni = (a - b);

    @Override
    public void start(Stage primaryStage) throws Exception {

        Function function = new Function();
        ListOfFunctions listOfFunctions = new ListOfFunctions();
        ListOfData listOfData = new ListOfData();
        RequestsProcessor processor = new RequestsProcessor();

        //TODO: PROCESSING CORRECTIONS OF USER'S INPUT
        BorderPane root = new BorderPane();


        //user interaction


        //Radio-buttons for functions selection
        Label labelFuncNumber = new Label("Choose the function to be analysed: ");
        RadioButton firstFunctionChoice = new RadioButton(listOfFunctions.getFirstFunctionAsString());
        RadioButton secondFunctionChoice = new RadioButton(listOfFunctions.getSecondFunctionAsString());
        RadioButton thirdFunctionChoice = new RadioButton(listOfFunctions.getThirdFunctionAsString());
        RadioButton forthFunctionChoice = new RadioButton(listOfFunctions.getForthFunctionAsString());
        RadioButton fifthFunctionChoice = new RadioButton(listOfFunctions.getFifthFunctionAsString());


        ToggleGroup rdBtnGroup = new ToggleGroup();
        firstFunctionChoice.setToggleGroup(rdBtnGroup);
        secondFunctionChoice.setToggleGroup(rdBtnGroup);
        thirdFunctionChoice.setToggleGroup(rdBtnGroup);
        forthFunctionChoice.setToggleGroup(rdBtnGroup);
        fifthFunctionChoice.setToggleGroup(rdBtnGroup);

        firstFunctionChoice.setOnAction(event -> {
            selectedFunction = 1;
        });

        secondFunctionChoice.setOnAction(event -> {
            selectedFunction = 2;
        });

        thirdFunctionChoice.setOnAction(event -> {
            selectedFunction = 3;
        });
        forthFunctionChoice.setOnAction(event -> {
            selectedFunction = 4;
        });
        fifthFunctionChoice.setOnAction(event -> {
            selectedFunction = 5;
        });


        FlowPane eqGroup = new FlowPane(Orientation.VERTICAL);
        eqGroup.getChildren().addAll(firstFunctionChoice, secondFunctionChoice, thirdFunctionChoice, forthFunctionChoice, fifthFunctionChoice);



        //Radio-buttons for data-set selection
        Label labelDataNumber = new Label("Choose a data-set to be used: ");
        RadioButton firstDataChoice = new RadioButton(listOfData.getFirstDataSetAsString());
        RadioButton secondDataChoice = new RadioButton(listOfData.getSecondDataSetAsString());
        RadioButton thirdDataChoice = new RadioButton(listOfData.getThirdDataSetAsString());
        RadioButton forthDataChoice = new RadioButton(listOfData.getForthDataSetAsString());
        RadioButton fifthDataChoice = new RadioButton(listOfData.getFifthDataSetAsString());


        ToggleGroup rdBtnGroupData = new ToggleGroup();
        firstDataChoice.setToggleGroup(rdBtnGroupData);
        secondDataChoice.setToggleGroup(rdBtnGroupData);
        thirdDataChoice.setToggleGroup(rdBtnGroupData);
        forthDataChoice.setToggleGroup(rdBtnGroupData);
        fifthDataChoice.setToggleGroup(rdBtnGroupData);

        firstDataChoice.setOnAction(event -> {
            selectedData = 1;
        });

        secondDataChoice.setOnAction(event -> {
            selectedData = 2;
        });

        thirdDataChoice.setOnAction(event -> {
            selectedData = 3;
        });
        forthDataChoice.setOnAction(event -> {
            selectedData = 4;
        });
        fifthDataChoice.setOnAction(event -> {
            selectedData = 5;
        });


        FlowPane eqGroupData = new FlowPane(Orientation.VERTICAL);
        eqGroupData.getChildren().addAll(firstDataChoice, secondDataChoice, thirdDataChoice, forthDataChoice, fifthDataChoice);




        //text fields

        Label xValueLabel = new Label("Type X value to be calculated: ");
        TextField xValueField = new TextField();

        Button buttonApply = new Button();
        buttonApply.setText("Apply");
        Label outputLabel = new Label();
        //TODO: rename or replace
        Label numPartitionsLabel = new Label();


        Group applyButton = new Group(buttonApply);

        //TODO: bind ctrlGroup to the Pane
        FlowPane ctrlGroup = new FlowPane(Orientation.VERTICAL, labelFuncNumber,
                firstFunctionChoice, secondFunctionChoice, thirdFunctionChoice, forthFunctionChoice, fifthFunctionChoice,
                labelDataNumber,
                firstDataChoice, secondDataChoice, thirdDataChoice, forthDataChoice, fifthDataChoice,
                xValueLabel, xValueField, applyButton, outputLabel, numPartitionsLabel);


        BorderPane.setAlignment(ctrlGroup, Pos.CENTER_LEFT);


        //FlowPane generalGroup = new FlowPane(Orientation.VERTICAL, ctrlGroup, sysCtrlGroup);
        //BorderPane.setAlignment(generalGroup, Pos.CENTER_LEFT);
        //root.setLeft(generalGroup);
        root.setLeft(ctrlGroup);


        //___________________________________________________________

        //graph
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        final LineChart<Number, Number> lineChart =
                new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Graph of the function and its interpolated version");

        XYChart.Series function1Series = new XYChart.Series();
        function1Series.setName("Original Function");
        XYChart.Series function2Series = new XYChart.Series();
        function2Series.setName("Interpolated Function");

        //TODO: remove if it doesn't work
        ObservableList<XYChart.Data> data = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> interpolationData = FXCollections.observableArrayList();


        BorderPane.setAlignment(lineChart, Pos.CENTER);
        root.setCenter(lineChart);


        //_________________________________________________


        //TODO: draw dots on the plot!

        buttonApply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    a = listOfData.getUpperLimit(selectedData);
                    b = listOfData.getLowerLimit(selectedData);
                    step = listOfData.getStep(selectedData);

                    if (a < b) {
                        tmp = a;
                        a = b;
                        b = tmp;
                    }

                    function1Series.getData().clear();
                    function2Series.getData().clear();


                    /*
                    for (int k = 0; k < previousStep; k++){
                        data.remove(k);
                    }
                    */
                    data.clear();
                    interpolationData.clear();


                    //TODO: correct graph with 50PI

                    if (a != b) {

                        //SystemResult result = iMethod.solve(selectedSystem, a, b, accuracy);
                        //sysOutputLabel.setText("X equals " + result.getX1Result() + " Y equals " + result.getX2Result());
                        //sysNumPartitionsLabel.setText("Number of partitions is: " + result.getNumberOfPartitions());
                        //TODO: add if any warnings are needed
                        //System.out.println(result.getWarningText());

                        ni = (a - b);
                        for (double i = 0; i <= ni; i += step) {
                            switch (selectedFunction) {
                                case (1): {
                                    //function1Series.getData().add(new XYChart.Data((b + i), (listOfFunctions.getFirstFunction(b + i))));
                                    //function2Series.getData().add(new XYChart.Data((b + i), (listOfFunctions.getSecondFunction(b + i))));
                                    data.add(new XYChart.Data((b + i), (listOfFunctions.getFirstFunction(b + i))));
                                    interpolationData.add(new XYChart.Data((b + i), (processor.analyseFunction(b + i,
                                            selectedFunction, selectedData))));
                                }
                                case (2): {
                                    //function1Series.getData().add(new XYChart.Data((b + i), (listOfFunctions.getSecondFunction(b + i))));
                                    //function2Series.getData().add(new XYChart.Data((b + i), (listOfSystems.e22Graph(b + i))));
                                    data.add(new XYChart.Data((b + i), (listOfFunctions.getSecondFunction(b + i))));
                                    interpolationData.add(new XYChart.Data((b + i), (processor.analyseFunction(b + i,
                                            selectedFunction, selectedData))));
                                }
                                case (3): {
                                    //function1Series.getData().add(new XYChart.Data((b + i), (listOfFunctions.getThirdFunction(b + i))));
                                    //function2Series.getData().add(new XYChart.Data((b + i), (listOfSystems.e22Graph(b + i))));
                                    data.add(new XYChart.Data((b + i), (listOfFunctions.getThirdFunction(b + i))));
                                    interpolationData.add(new XYChart.Data((b + i), (processor.analyseFunction(b + i,
                                            selectedFunction, selectedData))));
                                }
                                case (4): {
                                    //function1Series.getData().add(new XYChart.Data((b + i), (listOfFunctions.getForthFunction(b + i))));
                                    //function2Series.getData().add(new XYChart.Data((b + i), (listOfSystems.e22Graph(b + i))));
                                    data.add(new XYChart.Data((b + i), (listOfFunctions.getForthFunction(b + i))));
                                    interpolationData.add(new XYChart.Data((b + i), (processor.analyseFunction(b + i,
                                            selectedFunction, selectedData))));
                                }
                                case (5): {
                                    //function1Series.getData().add(new XYChart.Data((b + i), (listOfFunctions.getFifthFunction(b + i))));
                                    //function2Series.getData().add(new XYChart.Data((b + i), (listOfSystems.e22Graph(b + i))));
                                    data.add(new XYChart.Data((b + i), (listOfFunctions.getFifthFunction(b + i))));
                                    interpolationData.add(new XYChart.Data((b + i), (processor.analyseFunction(b + i,
                                            selectedFunction, selectedData))));
                                }
                            }
                        }

                        //TODO: new
                        function1Series.setData(data);
                        function2Series.setData(interpolationData);

                        lineChart.getData().add(function1Series);
                        lineChart.getData().add(function2Series);



                        previousStep = step;

                    } else {
                        //sysOutputLabel.setText("The limits are equal. Change them and try once more.");
                    }
                } catch (NumberFormatException e) {
                    //sysOutputLabel.setText("Wrong format of input detected. Correct it and try once more.");
                }
            }
        });


        //TODO: cleaning the lineChart to avoid multi-graph in the app
        //TODO: adaptation of the graph to displaying systems (multiple data in lineCharts)


        //______________________________________________________________


        //general settings
        Scene scene = new Scene(root);
        scene.setFill(Color.BEIGE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Interpolation plots and solutions");


        primaryStage.setWidth(1000);
        primaryStage.setHeight(500);


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
