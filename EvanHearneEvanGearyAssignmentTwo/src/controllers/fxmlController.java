package controllers;

// Evan Hearne (20097562) - Applied Computing (Cloud and Networks), Data Structures and Algorithms.

// Class incomplete - rest of class to be completed by Evan Geary.

// Updates - completed serialisation.

// SDK being used for JavaFX is for Apple Silicon, switch to different architecture SDK if needed.

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.BakedGood;
import models.BakedIngredients;
import models.GoodsList;
import models.Recipe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fxmlController implements Initializable {

    // All FXML fields instantiated here.
    @FXML
    public Button RecipeDeleteButton;
    @FXML
    public Button resetRecipeButton;
    @FXML
    public ChoiceBox<String> recipeBakedGoodChoiceBox;
    @FXML
    public ChoiceBox<String> recipeBakedIngredientsChoiceBox;
    @FXML
    public Button recipeAddButton;
    @FXML
    public ImageView BakedGoodImageView;
    public Button loadBakeryButton;
    public Button saveBakeryButton;
    public TextField SearchTextField;
    public Button SearchButton;
    public ListView SearchListView;
    @FXML
    private Button DeleteBakedGoodButton;
    @FXML
    private Button resetBakedGoodsButton;
    @FXML
    private Button addBakedGoodButton;
    @FXML
    private TextField BakedGoodNameTextField;
    @FXML
    private TextField BakedGoodCountryOfOriginTextField;
    @FXML
    private TextField BakedGoodDescriptionTextField;
    @FXML
    private TextField BakedGoodImageURLTextField;
    @FXML
    private TableView<BakedGood> BakedGoodTableView;
    @FXML
    private TableColumn<BakedGood, String> bakedGoodNameColumn;
    @FXML
    private TableColumn<BakedGood, String> BakedGoodCountryOfOriginColumn;
    @FXML
    private TableColumn<BakedGood, String> BakedGoodDescriptionColumn;
    @FXML
    private TableColumn<BakedGood, String> BakedGoodImageColumn;
    @FXML
    private Button DeleteBakedIngredientsButton;
    @FXML
    private Button resetBakedIngredientsButton;
    @FXML
    private Button addBakedIngredientsButton;
    @FXML
    private TextField BakedIngredientsNameTextField;
    @FXML
    private TextField BakedIngredientsDescriptionTextField;
    @FXML
    private TextField BakedIngredientsCaloriesTextField;
    @FXML
    private TextField BakedIngredientsQuantityTextField;
    @FXML
    private TableView<BakedIngredients> BakedIngredientsTableView;
    @FXML
    private TableColumn<BakedIngredients, String> BakedIngredientsNameColumn;
    @FXML
    private TableColumn<BakedIngredients, String> BakedIngredientsDescriptionColumn;
    @FXML
    private TableColumn<BakedIngredients, Number> BakedIngredientsCaloriesColumn;
    @FXML
    private TableColumn<BakedIngredients, Number> BakedIngredientsQuantityColumn;
    @FXML
    private TreeTableView<Object> RecipeTreeTableView;
    @FXML
    private TreeTableColumn<Object, String> RecipeBakedGoodNameTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, String> RecipeBakedGoodCountryOfOriginTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, String> RecipeBakedGoodDescriptionTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, String> RecipeBakedGoodImageTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, String> RecipeBakedIngredientsNameTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, String> RecipeBakedIngredientsDescriptionTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, Number> RecipeBakedIngredientsCaloriesTreeTableColumn;
    @FXML
    private TreeTableColumn<Object, Number> RecipeBakedIngredientsQuantityTreeTableColumn;

    // All methods for scenes found here.

    // BakedGood methods.

    // Instantiating a GoodsList with the BakedGood type inferred.
    GoodsList<BakedGood> bakedGoodGoodsList = new GoodsList<BakedGood>();

    // BakedGood ObservableList created for TableView.
    ObservableList<BakedGood> bakedGoodsObservableList = FXCollections.observableArrayList();

    public void selectBakedGoodImage(MouseEvent mouseEvent) {
        // Clears ImageView, in case a previous image was selected.
        BakedGoodImageView.setImage(null);
        // Sets the ImageView to the URL found in the selected BakedGood.
        BakedGoodImageView.setImage(new Image(BakedGoodTableView.getSelectionModel().getSelectedItem().getImageURL()));
    }

    @FXML
    public void deleteBakedGood(ActionEvent actionEvent) {
        // Deletes the selected BakedGood both from the GoodsList and ObservableList from the TableView.
        // If the button was pressed before selection, this if statement will prevent the code from running.
        if (BakedGoodTableView.getSelectionModel().getSelectedIndex() > -1) {
            bakedGoodGoodsList.delete(BakedGoodTableView.getSelectionModel().getSelectedIndex());
            bakedGoodsObservableList.remove(BakedGoodTableView.getSelectionModel().getSelectedIndex());
            populateBakedGoodTableView();

            // Populates Recipe ChoiceBoxes
            populateRecipeChoiceBoxes();
        }
    }

    @FXML
    public void resetBakedGoods(ActionEvent actionEvent) {
        // Resets the BakedGood GoodsList and ObservableArrayList.
        bakedGoodGoodsList.resetSystem();
        bakedGoodsObservableList.clear();
        populateBakedGoodTableView();

        // Populates Recipe ChoiceBoxes
        populateRecipeChoiceBoxes();
    }

    @FXML
    public void addBakedGood(ActionEvent actionEvent) {
        // Adds a BakedGood to the GoodsList.
        BakedGood a = new BakedGood(BakedGoodNameTextField.getText(), BakedGoodCountryOfOriginTextField.getText(), BakedGoodDescriptionTextField.getText(), BakedGoodImageURLTextField.getText());
        // Verifies there is content within all fields. If not, doesn't add.
        if (!(a.getName().equals("") || a.getCountry().equals("") || a.getDescription().equals("") || a.getImageURL().equals(""))) {
            bakedGoodGoodsList.addElement(a);
            // Populates the TableView.
            bakedGoodsObservableList.add(a);
            populateBakedGoodTableView();

            // Populates Recipe ChoiceBoxes
            populateRecipeChoiceBoxes();
        }
    }

    @FXML
    public void populateBakedGoodTableView() {
        // Clears table.
        BakedGoodTableView.getItems().clear();
        BakedGoodTableView.getColumns().clear();
        // Clears ImageView
        BakedGoodImageView.setImage(null);
        // Populates table.
        bakedGoodNameColumn.setCellValueFactory(new PropertyValueFactory<BakedGood, String>("name"));
        BakedGoodCountryOfOriginColumn.setCellValueFactory(new PropertyValueFactory<BakedGood, String>("country"));
        BakedGoodDescriptionColumn.setCellValueFactory(new PropertyValueFactory<BakedGood, String>("description"));
        BakedGoodImageColumn.setCellValueFactory(new PropertyValueFactory<BakedGood, String>("imageURL"));
        BakedGoodTableView.getColumns().addAll(bakedGoodNameColumn, BakedGoodCountryOfOriginColumn, BakedGoodDescriptionColumn, BakedGoodImageColumn);
        BakedGoodTableView.getItems().addAll(bakedGoodsObservableList);
    }

    // BakedIngredients methods.

    // Instantiating a GoodsList with the BakedIngredients type inferred.
    GoodsList<BakedIngredients> bakedIngredientsGoodsList = new GoodsList<>();

    // BakedIngredients ObservableList created for TableView.
    ObservableList<BakedIngredients> bakedIngredientsObservableList = FXCollections.observableArrayList();


    @FXML
    public void deleteBakedIngredients(ActionEvent actionEvent) {
        // Deletes the selected BakedIngredients both from the GoodsList and ObservableList from the TableView.
        // If the button was pressed before selection, this if statement will prevent the code from running.
        if (BakedIngredientsTableView.getSelectionModel().getSelectedIndex() > -1) {
            bakedIngredientsGoodsList.delete(BakedIngredientsTableView.getSelectionModel().getSelectedIndex());
            bakedIngredientsObservableList.remove(BakedIngredientsTableView.getSelectionModel().getSelectedIndex());
            populateBakedIngredientsTableView();
        }

        // Populates Recipe ChoiceBoxes
        populateRecipeChoiceBoxes();
    }
    @FXML
    public void resetBakedIngredients(ActionEvent actionEvent) {
        // Resets the BakedIngredients GoodsList and ObservableArrayList.
        bakedIngredientsGoodsList.resetSystem();
        bakedIngredientsObservableList.clear();
        populateBakedIngredientsTableView();

        // Populates Recipe ChoiceBoxes
        populateRecipeChoiceBoxes();
    }

    @FXML
    public void addBakedIngredients(ActionEvent actionEvent) {
        // Adds a BakedGood to the GoodsList.
        BakedIngredients a = new BakedIngredients(BakedIngredientsNameTextField.getText(), BakedIngredientsDescriptionTextField.getText(), Integer.parseInt(BakedIngredientsCaloriesTextField.getText()), Integer.parseInt(BakedIngredientsQuantityTextField.getText()));
        // Verifies there is content within all fields. If not, doesn't add.
        if (!(a.getIngredientsName().equals("") || a.getIngredientsDescription().equals("") || a.getIngredientsCalories() <= 0 || a.getQuantity() <= 0)) {
            bakedIngredientsGoodsList.addElement(a);
            // Populates the TableView.
            bakedIngredientsObservableList.add(a);
            populateBakedIngredientsTableView();

            // Populates Recipe ChoiceBoxes
            populateRecipeChoiceBoxes();
        }
    }

    @FXML
    public void populateBakedIngredientsTableView() {
        // Clears table.
        BakedIngredientsTableView.getItems().clear();
        BakedIngredientsTableView.getColumns().clear();
        // Populates table.
        BakedIngredientsNameColumn.setCellValueFactory(new PropertyValueFactory<BakedIngredients, String>("ingredientsName"));
        BakedIngredientsDescriptionColumn.setCellValueFactory(new PropertyValueFactory<BakedIngredients, String>("ingredientsDescription"));
        BakedIngredientsCaloriesColumn.setCellValueFactory(new PropertyValueFactory<BakedIngredients, Number>("ingredientsCalories"));
        BakedIngredientsQuantityColumn.setCellValueFactory(new PropertyValueFactory<BakedIngredients, Number>("quantity"));
        BakedIngredientsTableView.getColumns().addAll(BakedIngredientsNameColumn, BakedIngredientsDescriptionColumn, BakedIngredientsCaloriesColumn, BakedIngredientsQuantityColumn);
        BakedIngredientsTableView.getItems().addAll(bakedIngredientsObservableList);
    }

    // Recipe methods.

    // Recipe GoodsList.
    GoodsList<Recipe> recipeGoodsList = new GoodsList<>();

    // Recipe ObservableList.
    ObservableList<Recipe> recipeObservableList = FXCollections.observableArrayList();

    public void populateRecipeChoiceBoxes() {
        // Clears ChoiceBox-es
        recipeBakedGoodChoiceBox.getItems().clear();
        recipeBakedIngredientsChoiceBox.getItems().clear();

        // Uses for loop to populate ChoiceBox-es. Indexes used to determine which item is used as there may be duplicates.
        for (BakedGood bakedGood: bakedGoodsObservableList)
            recipeBakedGoodChoiceBox.getItems().add(bakedGoodsObservableList.indexOf(bakedGood) + ". " + bakedGood.getName());
        for (BakedIngredients bakedIngredients: bakedIngredientsObservableList)
            recipeBakedIngredientsChoiceBox.getItems().add(bakedIngredientsObservableList.indexOf(bakedIngredients) + ". " + bakedIngredients.getIngredientsName());
    }

    @FXML
    public void populateRecipeTreeTableView() {
        // Setting root of TreeTableView to be the entire list of BakedGoods within the Recipe list.
        final TreeItem<Object> root = new TreeItem<>();
        for (Recipe recipe: recipeObservableList) {
            TreeItem<Object> bakedGoodItem = new TreeItem<>(recipe.getBakedGood());
            TreeItem<Object> bakedIngredientsItem = new TreeItem<>(recipe.getBakedIngredients());
            bakedGoodItem.getChildren().add(bakedIngredientsItem);
            root.getChildren().add(bakedGoodItem);
        }
        RecipeTreeTableView.setRoot(root);
        RecipeTreeTableView.setShowRoot(false);
    }

    @FXML
    public void populateRecipeTreeTableColumns() {
        // Sets up the values to expect for the TreeTableView.
        RecipeBakedGoodNameTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedGood a)
                return new SimpleStringProperty(a.getName());
            else
                return null;
        });
        RecipeBakedGoodCountryOfOriginTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedGood a)
                return new SimpleStringProperty(a.getCountry());
            else
                return null;
        });
        RecipeBakedGoodDescriptionTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedGood a)
                return new SimpleStringProperty(a.getDescription());
            else
                return null;
        });
        RecipeBakedGoodImageTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedGood a)
                return new SimpleStringProperty(a.getImageURL());
            else
                return null;
        });
        RecipeBakedIngredientsNameTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedIngredients a)
                return new SimpleStringProperty(a.getIngredientsName());
            else
                return null;
        });
        RecipeBakedIngredientsDescriptionTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedIngredients a)
                return new SimpleStringProperty(a.getIngredientsDescription());
            else
                return null;
        });
        RecipeBakedIngredientsQuantityTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedIngredients a)
                return new SimpleIntegerProperty(a.getQuantity());
            else
                return null;
        });
        RecipeBakedIngredientsCaloriesTreeTableColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && rowItem.getValue() instanceof BakedIngredients a)
                return new SimpleIntegerProperty(a.getIngredientsCalories());
            else
                return null;
        });
    }

    public void deleteRecipe(ActionEvent actionEvent) {
        // Ensures that the selected index, even after deletion of everything, remains higher than -1.
        if (RecipeTreeTableView.getSelectionModel().getSelectedIndex() > -1) {
            recipeGoodsList.delete(RecipeTreeTableView.getSelectionModel().getSelectedIndex());
            recipeObservableList.remove(RecipeTreeTableView.getSelectionModel().getSelectedIndex());
            populateRecipeTreeTableView();
        }
    }

    public void resetRecipes(ActionEvent actionEvent) {
        // Resets entire TableView.
        recipeGoodsList.resetSystem();
        recipeObservableList.clear();
        populateRecipeTreeTableView();
    }

    public void addRecipe(ActionEvent actionEvent) {
        // Ensures choice boxes are selected for below code to run.
        if (recipeBakedGoodChoiceBox.getSelectionModel().getSelectedIndex() > -1 && recipeBakedIngredientsChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            Recipe a = new Recipe(bakedGoodsObservableList.get(recipeBakedGoodChoiceBox.getSelectionModel().getSelectedIndex()), bakedIngredientsObservableList.get(recipeBakedIngredientsChoiceBox.getSelectionModel().getSelectedIndex()));
            recipeGoodsList.addElement(a);
            recipeObservableList.add(a);
            populateRecipeTreeTableColumns();
            populateRecipeTreeTableView();
        }
    }
    // General methods - Load and Save, Populate

    public void populate() {
        // Clears and Populates all ObservableLists.
        bakedGoodsObservableList.clear();
        bakedIngredientsObservableList.clear();
        recipeObservableList.clear();

        bakedGoodsObservableList = bakedGoodGoodsList.listGoodNodes();
        bakedIngredientsObservableList = bakedIngredientsGoodsList.listGoodNodes();
        recipeObservableList = recipeGoodsList.listGoodNodes();
        // Populates all JavaFX Components.
        populateBakedGoodTableView();
        populateBakedIngredientsTableView();
        populateRecipeChoiceBoxes();
        populateRecipeTreeTableColumns();
        populateRecipeTreeTableView();
    }
    public void loadBakery(ActionEvent actionEvent) throws Exception{
        // Loads bakery components - BakedGood, BakedIngredients, Recipe by setting the list from their files.
        bakedGoodGoodsList.load("bakedGoodGoodsList");
        bakedIngredientsGoodsList.load("bakedIngredientsGoodsList");
        recipeGoodsList.load("recipe");
        populate();
    }

    public void saveBakery(ActionEvent actionEvent) throws Exception {
        // Saves all GoodsLists to their proprietary files.
        bakedGoodGoodsList.save("bakedGoodGoodsList");
        bakedIngredientsGoodsList.save("bakedIngredientsGoodsList");
        recipeGoodsList.save("recipe");

    }
    // When the scene first loads, the user is presented with a welcome screen. This method listens out for an event
    // i.e. a button clicked, then it switched to the main scene with all the app contents.
    @FXML
    void switchToMainScene(Event event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }



}

