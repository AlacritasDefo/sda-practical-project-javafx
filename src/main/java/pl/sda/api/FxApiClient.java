package pl.sda.api;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import pl.sda.api.swapi.config.Resource;
import pl.sda.api.swapi.model.*;
import pl.sda.api.swapi.repository.SWAPIGenericRepository;
import pl.sda.api.swapi.repository.SWAPIRepository;

import java.io.IOException;
import java.util.Optional;

public class FxApiClient extends Application {
    //    Deklaracja konteneru
    public VBox root = new VBox();
    public HBox buttons = new HBox();
    public VBox personDetails = new VBox();
    public HBox actionButtons = new HBox();
    public SWAPIRepository<Person> people = new SWAPIGenericRepository<>(Resource.PEOPLE);
    public SWAPIRepository<Film> film = new SWAPIGenericRepository<>(Resource.FILMS);
    public SWAPIRepository<Planet> planet = new SWAPIGenericRepository<>(Resource.PLANETS);
    public SWAPIRepository<Species> species = new SWAPIGenericRepository<>(Resource.SPECIES);
    public SWAPIRepository<Starship> starship = new SWAPIGenericRepository<>(Resource.STARSHIPS);
    public SWAPIRepository<Vehicle> vehicle = new SWAPIGenericRepository<>(Resource.VEHICLES);
    public Button goVehicle = new Button("Pojazdy");
    public Button goPlanets = new Button("Planety");
    public Button goFilms = new Button("Filmy");
    public Button goPeople = new Button("Postacie");
    public Button goSpecies = new Button("Rasy");
    public Button goStarships = new Button("Statki");
    public Button next = new Button("Wyświetl następny");
    public Button last = new Button("Wyświetl poprzedni");
    public Spinner<Integer> personId = new Spinner<>(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 1));
    public Label labelName = new Label("Wyświetlanie imienia!");
    public Label labelHeight = new Label("Wyświetlanie wzrostu!");
    public Label labelGender = new Label("Wyświetlanie płci!");

    @Override
    public void start(Stage stage) throws Exception {
        actionButtons.setAlignment(Pos.CENTER);
        actionButtons.setSpacing(20);
        actionButtons.setPadding(new Insets(10));
        buttons.setAlignment(Pos.CENTER_LEFT);
        buttons.setSpacing(20);
        buttons.setPadding(new Insets(10));

        personDetails.setAlignment(Pos.TOP_LEFT);
        personDetails.setSpacing(15);
        personDetails.setPadding(new Insets(15, 10, 10, 20));
        personDetails.setBorder(new Border(new BorderStroke(Color.BLUEVIOLET, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        final Optional<Vehicle> vehicleById = vehicle.findById(1);
        final Optional<Starship> starshipById = starship.findById(1);
        final Optional<Planet> planetById = planet.findById(1);
        final Optional<Person> personById = people.findById(1);
        final Optional<Film> filmById = film.findById(1);
        final Optional<Species> speciesById = species.findById(1);

        Button showPersonBtn = new Button("Pobierz");

        goPeople.setOnAction(actionEvent -> {
            root.getChildren().addAll(personId, showPersonBtn, actionButtons, personDetails);
        });
//        Label frontLabel = new Label("SWApi App");

//        Label labelName = new Label(people.findById(2).get().getName());
//        DEKLARACJA ETYKIET

        labelGender.setFont(Font.font("Lato", FontWeight.BLACK, 24));
        labelHeight.setFont(Font.font("Lato", FontWeight.BLACK, 24));
        labelName.setFont(Font.font("Lato", FontWeight.BLACK, 24));

//        TWORZENIE PRZYCISKU
        showPersonBtn.setOnAction(actionEvent -> {
            int id = personId.getValue();
            showPersonDetails(id);
        });
        next.setOnAction(actionEvent -> {
            int id = personId.getValue() + 1;
            personId.getValueFactory().setValue(id);
            try {
                final Optional<Person> optionalPerson;
                optionalPerson = people.findById(id);
                if (optionalPerson.isPresent()) {
                    labelGender.setText(optionalPerson.get().getGender());
                    labelHeight.setText(optionalPerson.get().getHeight());
                    labelName.setText(optionalPerson.get().getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        last.setOnAction(actionEvent -> {

            int id = personId.getValue() - 1;
            personId.getValueFactory().setValue(id);
            try {
                final Optional<Person> optionalPerson;
                optionalPerson = people.findById(id);
                if (optionalPerson.isPresent()) {
                    labelGender.setText(optionalPerson.get().getGender());
                    labelHeight.setText(optionalPerson.get().getHeight());
                    labelName.setText(optionalPerson.get().getName());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        actionButtons.getChildren().addAll(next, last);
        buttons.getChildren().addAll(goPeople, goPlanets, goSpecies, goStarships, goVehicle, goFilms);
        personDetails.getChildren().addAll(labelName, labelGender, labelHeight);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
//        DODAWANIE ETYKIET DO ROOT
        root.getChildren().addAll(buttons);
//        root.getChildren().addAll(buttons, personId, showPersonBtn, personDetails);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Demo FX App");
        stage.show();

    }

    private void showPersonDetails(int id) {
        try {
            final Optional<Person> optionalPerson;
            optionalPerson = people.findById(id);
            if (optionalPerson.isPresent()) {

                labelGender.setText(optionalPerson.get().getGender());
                labelHeight.setText(optionalPerson.get().getHeight());
                labelName.setText(optionalPerson.get().getName());
            } else {
                labelName.setText("Nie ma postaci o takim Id");
                labelGender.setText("Nie ma postaci o takim Id");
                labelHeight.setText("Nie ma postaci o takim Id");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}