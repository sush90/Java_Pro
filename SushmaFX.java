/*
 * Author: Sushma Upadhayay
 * Project: SushmaPortfolioFX - Interactive Showcase
 * Description:
 *   A JavaFX portfolio integrating About Me, Car Animation, Slot Machine, and Basketball Game
 *   into one cinematic "Casino City" app.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.util.Duration;
import java.util.Random;

public class SushmaFX extends Application {

    private Stage mainStage;
    private double balance = 100.00;
    private Random rand = new Random();
    private int basketballScore = 0;

    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        mainStage.setTitle("🎰 SushmaFX - Tech & Creativity Showcase");
        mainStage.setScene(buildMainMenu());
        mainStage.show();
    }

    /* 🎡 ENHANCED MAIN MENU */
    private Scene buildMainMenu() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #0f0c29, #302b63, #24243e);");

        // Animated tech-themed title
        Text title = new Text("⚡ SUSHMA'S TECH UNIVERSE ⚡");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        title.setFill(Color.CYAN);
        title.setEffect(new javafx.scene.effect.Glow(0.8));
        
        Text subtitle = new Text("💻 Code • Design • Innovation • Fun 🎮");
        subtitle.setFont(Font.font("Courier New", FontPosture.ITALIC, 20));
        subtitle.setFill(Color.LIGHTGREEN);
        
        // Animated tech quote
        Text quote = new Text("\"Technology is best when it brings people together\" - Matt Mullenweg");
        quote.setFont(Font.font("Arial", FontPosture.ITALIC, 14));
        quote.setFill(Color.LIGHTBLUE);
        
        VBox topBox = new VBox(10, title, subtitle, quote);
        topBox.setAlignment(Pos.CENTER);
        root.setTop(topBox);
        BorderPane.setMargin(topBox, new Insets(30, 0, 10, 0));
        
        // Pulsing animation for title
        FadeTransition fade = new FadeTransition(Duration.seconds(2), title);
        fade.setFromValue(1.0);
        fade.setToValue(0.6);
        fade.setCycleCount(Animation.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        // Profile image placeholder with tech border
        StackPane imageContainer = new StackPane();
        
        // Tech-themed decorative circles
        Circle outerCircle = new Circle(100);
        outerCircle.setFill(Color.TRANSPARENT);
        outerCircle.setStroke(Color.CYAN);
        outerCircle.setStrokeWidth(3);
        
        Circle innerCircle = new Circle(90);
        innerCircle.setFill(Color.DARKSLATEBLUE);
        innerCircle.setStroke(Color.LIGHTBLUE);
        innerCircle.setStrokeWidth(2);
        
        // Try to load profile image
        try {
            ImageView profileImage = new ImageView(new Image("Professional.png"));
            profileImage.setFitWidth(150);
            profileImage.setFitHeight(180);
            profileImage.setPreserveRatio(true);
            
            // Circular clip for image
            Circle clip = new Circle(90, 90, 90);
            profileImage.setClip(clip);
            
            imageContainer.getChildren().addAll(outerCircle, innerCircle, profileImage);
        } catch (Exception e) {
            // Fallback if image not found
            Text placeholderText = new Text("📸");
            placeholderText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            placeholderText.setFill(Color.WHITE);
            placeholderText.setTextAlignment(TextAlignment.CENTER);
            
            imageContainer.getChildren().addAll(outerCircle, innerCircle, placeholderText);
        }
        
        // Rotating animation for outer circle
        RotateTransition rotate = new RotateTransition(Duration.seconds(5), outerCircle);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.play();

        // Enhanced buttons with tech icons
        Button aboutBtn = createButton("💁 About Me", e -> switchScene(buildAboutScene()));
        Button carBtn = createButton("🚗 Drive the Car", e -> switchScene(buildCarScene()));
        Button slotBtn = createButton("🎰 Play Slot Machine", e -> switchScene(buildSlotScene()));
        Button ballBtn = createButton("🏀 Basketball Challenge", e -> switchScene(buildBallScene()));
        Button exitBtn = createButton("❌ Exit", e -> mainStage.close());

        VBox buttonBox = new VBox(15, aboutBtn, carBtn, slotBtn, ballBtn, exitBtn);
        buttonBox.setAlignment(Pos.CENTER);
        
        VBox centerBox = new VBox(30, imageContainer, buttonBox);
        centerBox.setAlignment(Pos.CENTER);

        root.setCenter(centerBox);
        
        // Footer with tech elements
        Text footer = new Text("🔧 Built with JavaFX • 🎨 Designed with Passion • ⚡ Powered by Creativity");
        footer.setFont(Font.font("Arial", 12));
        footer.setFill(Color.LIGHTGRAY);
        HBox footerBox = new HBox(footer);
        footerBox.setAlignment(Pos.CENTER);
        footerBox.setPadding(new Insets(10));
        root.setBottom(footerBox);

        return new Scene(root, 900, 600);
    }

    /* 💁 ENHANCED ABOUT ME */
    private Scene buildAboutScene() {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom right, #ffecd2, #fcb69f);");

        // Title
        Label name = new Label("💫 Sushma Upadhayay 💫");
        name.setFont(Font.font("Verdana", FontWeight.BOLD, 32));
        name.setTextFill(Color.web("#8B008B"));
        
        // Image placeholder with frame
        VBox imageBox = new VBox();
        imageBox.setAlignment(Pos.CENTER);
        
        StackPane photoStack;
        try {
            ImageView aboutImage = new ImageView(new Image("file:Sushma (2).jpg"));
            aboutImage.setFitWidth(200);
            aboutImage.setFitHeight(200);
            aboutImage.setPreserveRatio(true);
            
            Rectangle photoFrame = new Rectangle(210, 210);
            photoFrame.setFill(Color.TRANSPARENT);
            photoFrame.setStroke(Color.DARKGRAY);
            photoFrame.setStrokeWidth(5);
            photoFrame.setArcWidth(20);
            photoFrame.setArcHeight(20);
            
            photoStack = new StackPane(aboutImage, photoFrame);
        } catch (Exception e) {
            Rectangle photoFrame = new Rectangle(200, 200);
            photoFrame.setFill(Color.LIGHTGRAY);
            photoFrame.setStroke(Color.DARKGRAY);
            photoFrame.setStrokeWidth(5);
            photoFrame.setArcWidth(20);
            photoFrame.setArcHeight(20);
            
            Text photoPlaceholder = new Text("📸\n\nYour Beautiful\nPhoto Here!\n\n(Upload Later)");
            photoPlaceholder.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            photoPlaceholder.setFill(Color.DARKGRAY);
            photoPlaceholder.setTextAlignment(TextAlignment.CENTER);
            
            photoStack = new StackPane(photoFrame, photoPlaceholder);
        }
        
        imageBox.getChildren().add(photoStack);

        // Story section with better formatting
        Text storyTitle = new Text("📖 My Story");
        storyTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        storyTitle.setFill(Color.DARKRED);
        
        Text story = new Text(
            "Welcome to my world of creativity and code! ✨\n\n" +
            "I'm a Computer Science student at Bucknell University with a deep passion\n" +
            "for technology, design, and creativity.\n\n" +
            "I love turning ideas into interactive digital experiences like this app\n" +
            "you're exploring now!\n\n" +
            "Outside of coding, I find joy in dancing, traveling, and discovering\n" +
            "new cultures.\n\n" +
            "My goal is to bridge creativity and innovation to build technology\n" +
            "that makes people smile 🌍"
        );
        story.setFont(Font.font("Arial", 16));
        story.setFill(Color.web("#2C3E50"));
        story.setTextAlignment(TextAlignment.CENTER);
        
        VBox storyBox = new VBox(15, storyTitle, story);
        storyBox.setAlignment(Pos.CENTER);
        storyBox.setMaxWidth(700);

        VBox centerBox = new VBox(25, name, imageBox, storyBox);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(20));

        Button back = createButton("⬅ Back to Main Menu", e -> switchScene(buildMainMenu()));
        VBox bottomBox = new VBox(back);
        bottomBox.setAlignment(Pos.CENTER);
        VBox.setMargin(back, new Insets(20));

        ScrollPane scrollPane = new ScrollPane(centerBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        
        pane.setCenter(scrollPane);
        pane.setBottom(bottomBox);

        return new Scene(pane, 900, 600);
    }

    /* 🚗 INTERACTIVE CAR SCENE WITH DRIVE CONTROLS */
    private Scene buildCarScene() {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom, #87CEEB, #E0FFFF);");

        // Road
        Rectangle road = new Rectangle(0, 450, 900, 150);
        road.setFill(Color.DARKGRAY);
        
        // Road lines
        for (int i = 0; i < 900; i += 60) {
            Rectangle line = new Rectangle(i, 520, 40, 8);
            line.setFill(Color.YELLOW);
            pane.getChildren().add(line);
        }

        // Car body
        Rectangle carBody = new Rectangle(250, 350, 200, 60);
        carBody.setFill(Color.RED);
        carBody.setArcWidth(15);
        carBody.setArcHeight(15);
        
        Rectangle carRoof = new Rectangle(280, 320, 140, 40);
        carRoof.setFill(Color.DARKRED);
        carRoof.setArcWidth(10);
        carRoof.setArcHeight(10);
        
        Polygon windshield = new Polygon();
        windshield.getPoints().addAll(
            290.0, 360.0,
            320.0, 330.0,
            360.0, 330.0,
            390.0, 360.0
        );
        windshield.setFill(Color.LIGHTBLUE);
        windshield.setStroke(Color.BLACK);
        windshield.setStrokeWidth(2);
        
        Circle wheel1 = new Circle(290, 410, 25, Color.BLACK);
        Circle wheel2 = new Circle(410, 410, 25, Color.BLACK);
        Circle hubcap1 = new Circle(290, 410, 12, Color.LIGHTGRAY);
        Circle hubcap2 = new Circle(410, 410, 12, Color.LIGHTGRAY);
        
        Circle headlight1 = new Circle(445, 365, 8, Color.YELLOW);
        Circle headlight2 = new Circle(445, 395, 8, Color.YELLOW);
        Circle taillight = new Circle(255, 375, 8, Color.RED);
        Rectangle handle = new Rectangle(350, 380, 15, 5);
        handle.setFill(Color.SILVER);
        
        Group carGroup = new Group(
            carBody, carRoof, windshield, 
            wheel1, wheel2, hubcap1, hubcap2,
            headlight1, headlight2, taillight, handle
        );

        pane.getChildren().addAll(road, carGroup);

        // Drive controls
        Label instructions = new Label("🎮 CLICK SCREEN, THEN USE ARROW KEYS! ⬅️ LEFT | ➡️ RIGHT | ⬆️ BOOST | ⬇️ BRAKE");
        instructions.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        instructions.setTextFill(Color.DARKBLUE);
        instructions.setLayoutX(130);
        instructions.setLayoutY(50);
        
        Label speedLabel = new Label("Speed: 0 mph");
        speedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        speedLabel.setTextFill(Color.DARKRED);
        speedLabel.setLayoutX(400);
        speedLabel.setLayoutY(90);

        Button back = createButton("⬅ Back", e -> switchScene(buildMainMenu()));
        back.setLayoutX(20);
        back.setLayoutY(20);
        
        pane.getChildren().addAll(instructions, speedLabel, back);
        
        // Wheel rotation
        RotateTransition rotate1 = new RotateTransition(Duration.seconds(1), wheel1);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(Animation.INDEFINITE);
        
        RotateTransition rotate2 = new RotateTransition(Duration.seconds(1), wheel2);
        rotate2.setByAngle(360);
        rotate2.setCycleCount(Animation.INDEFINITE);

        Scene scene = new Scene(pane, 900, 600);
        
        // Keyboard controls with focus
        final double[] speed = {0};
        
        // Request focus so keyboard events work
        pane.setFocusTraversable(true);
        pane.requestFocus();
        
        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case RIGHT:
                case D:
                    if (carGroup.getTranslateX() < 300) {
                        carGroup.setTranslateX(carGroup.getTranslateX() + 20);
                        speed[0] = Math.min(speed[0] + 10, 100);
                        speedLabel.setText("Speed: " + (int)speed[0] + " mph ➡️");
                        if (rotate1.getStatus() != Animation.Status.RUNNING) {
                            rotate1.play();
                            rotate2.play();
                        }
                    }
                    break;
                case LEFT:
                case A:
                    if (carGroup.getTranslateX() > -200) {
                        carGroup.setTranslateX(carGroup.getTranslateX() - 20);
                        speed[0] = Math.min(speed[0] + 10, 100);
                        speedLabel.setText("Speed: " + (int)speed[0] + " mph ⬅️");
                        if (rotate1.getStatus() != Animation.Status.RUNNING) {
                            rotate1.play();
                            rotate2.play();
                        }
                    }
                    break;
                case UP:
                case W:
                    // Speed boost visual effect
                    if (speed[0] < 100) {
                        speed[0] = Math.min(speed[0] + 20, 100);
                        speedLabel.setText("Speed: " + (int)speed[0] + " mph ⬆️ BOOST!");
                        speedLabel.setTextFill(Color.GREEN);
                    }
                    break;
                case DOWN:
                case S:
                    // Brake
                    speed[0] = Math.max(speed[0] - 30, 0);
                    speedLabel.setText("Speed: " + (int)speed[0] + " mph 🛑 BRAKE");
                    speedLabel.setTextFill(Color.RED);
                    if (speed[0] == 0) {
                        rotate1.pause();
                        rotate2.pause();
                    }
                    break;
            }
            e.consume();
        });
        
        pane.setOnKeyReleased(e -> {
            speed[0] = Math.max(speed[0] - 5, 0);
            speedLabel.setText("Speed: " + (int)speed[0] + " mph");
            speedLabel.setTextFill(Color.DARKRED);
            if (speed[0] == 0) {
                rotate1.pause();
                rotate2.pause();
            }
            e.consume();
        });
        
        // Make sure pane gets focus when clicked
        pane.setOnMouseClicked(e -> pane.requestFocus());

        return scene;
    }

    /* 🎰 SLOT MACHINE SCENE */
    private Scene buildSlotScene() {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #3b0a45, #982c9d);");

        Label title = new Label("🎰 Casino Slot Machine 🎰");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        title.setTextFill(Color.GOLD);

        String[] symbols = {"🍒", "🍋", "🍊", "🍇", "💎", "7️⃣"};
        
        Text reel1 = new Text(symbols[0]);
        Text reel2 = new Text(symbols[1]);
        Text reel3 = new Text(symbols[2]);
        
        reel1.setFont(Font.font("Verdana", FontWeight.BOLD, 100));
        reel2.setFont(Font.font("Verdana", FontWeight.BOLD, 100));
        reel3.setFont(Font.font("Verdana", FontWeight.BOLD, 100));
        
        StackPane box1 = new StackPane(reel1);
        StackPane box2 = new StackPane(reel2);
        StackPane box3 = new StackPane(reel3);
        
        box1.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-padding: 20;");
        box2.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-padding: 20;");
        box3.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-padding: 20;");
        
        box1.setMinSize(140, 140);
        box2.setMinSize(140, 140);
        box3.setMinSize(140, 140);
        
        HBox reelBox = new HBox(20, box1, box2, box3);
        reelBox.setAlignment(Pos.CENTER);
        reelBox.setStyle("-fx-background-color: #8B4513; -fx-padding: 30; -fx-background-radius: 20;");

        TextField amountField = new TextField();
        amountField.setPromptText("Enter bet amount");
        amountField.setMaxWidth(200);
        amountField.setStyle("-fx-font-size: 16px;");
        
        Label balanceLabel = new Label("💰 Balance: $" + String.format("%.2f", balance));
        balanceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        balanceLabel.setTextFill(Color.YELLOW);
        
        Label resultLabel = new Label("");
        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        resultLabel.setTextFill(Color.LIGHTGREEN);

        Button spinBtn = createButton("🎲 SPIN!", e -> {
            try {
                double bet = Double.parseDouble(amountField.getText());
                if (bet <= 0 || bet > balance) {
                    resultLabel.setText("❌ Invalid bet amount!");
                    resultLabel.setTextFill(Color.RED);
                    return;
                }
                
                int r1 = rand.nextInt(6);
                int r2 = rand.nextInt(6);
                int r3 = rand.nextInt(6);
                
                reel1.setText(symbols[r1]);
                reel2.setText(symbols[r2]);
                reel3.setText(symbols[r3]);
                
                double win = 0;
                if (r1 == r2 && r2 == r3) {
                    win = bet * 5;
                    resultLabel.setText("🎉 JACKPOT! You won $" + String.format("%.2f", win) + "!");
                    resultLabel.setTextFill(Color.GOLD);
                } else if (r1 == r2 || r2 == r3 || r1 == r3) {
                    win = bet * 2;
                    resultLabel.setText("✨ Two Match! You won $" + String.format("%.2f", win) + "!");
                    resultLabel.setTextFill(Color.LIGHTGREEN);
                } else {
                    resultLabel.setText("😢 No match. Try again!");
                    resultLabel.setTextFill(Color.LIGHTCORAL);
                }
                
                balance += win - bet;
                balanceLabel.setText("💰 Balance: $" + String.format("%.2f", balance));
                
            } catch (NumberFormatException ex) {
                resultLabel.setText("❌ Please enter a valid number!");
                resultLabel.setTextFill(Color.RED);
            }
        });

        Button back = createButton("⬅ Back", e -> switchScene(buildMainMenu()));

        root.getChildren().addAll(title, reelBox, amountField, balanceLabel, spinBtn, resultLabel, back);
        return new Scene(root, 900, 600);
    }

    /* 🏀 INTERACTIVE BASKETBALL GAME */
    private Scene buildBallScene() {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: linear-gradient(to bottom, #1a1a2e, #16213e);");

        Rectangle floor = new Rectangle(0, 500, 900, 100);
        floor.setFill(Color.web("#8B4513"));
        
        Line centerLine = new Line(450, 500, 450, 600);
        centerLine.setStroke(Color.WHITE);
        centerLine.setStrokeWidth(3);

        Rectangle backboard = new Rectangle(700, 200, 10, 100);
        backboard.setFill(Color.WHITE);
        backboard.setStroke(Color.BLACK);
        backboard.setStrokeWidth(2);
        
        Ellipse rim = new Ellipse(680, 280, 40, 8);
        rim.setFill(Color.TRANSPARENT);
        rim.setStroke(Color.ORANGE);
        rim.setStrokeWidth(4);
        
        Rectangle pole = new Rectangle(695, 300, 10, 200);
        pole.setFill(Color.GRAY);
        
        Line net1 = new Line(640, 280, 650, 320);
        Line net2 = new Line(655, 280, 660, 320);
        Line net3 = new Line(670, 280, 670, 320);
        Line net4 = new Line(685, 280, 680, 320);
        Line net5 = new Line(700, 280, 690, 320);
        Line net6 = new Line(715, 280, 700, 320);
        net1.setStroke(Color.WHITE); net2.setStroke(Color.WHITE);
        net3.setStroke(Color.WHITE); net4.setStroke(Color.WHITE);
        net5.setStroke(Color.WHITE); net6.setStroke(Color.WHITE);
        net1.setStrokeWidth(2); net2.setStrokeWidth(2);
        net3.setStrokeWidth(2); net4.setStrokeWidth(2);
        net5.setStrokeWidth(2); net6.setStrokeWidth(2);
        
        Circle ball = new Circle(150, 450, 30);
        ball.setFill(Color.ORANGE);
        ball.setStroke(Color.BLACK);
        ball.setStrokeWidth(2);
        
        Arc ballLine1 = new Arc(150, 450, 25, 25, 0, 180);
        ballLine1.setFill(Color.TRANSPARENT);
        ballLine1.setStroke(Color.BLACK);
        ballLine1.setStrokeWidth(2);
        
        Arc ballLine2 = new Arc(150, 450, 25, 25, 180, 180);
        ballLine2.setFill(Color.TRANSPARENT);
        ballLine2.setStroke(Color.BLACK);
        ballLine2.setStrokeWidth(2);
        
        Line ballLine3 = new Line(150, 425, 150, 475);
        ballLine3.setStroke(Color.BLACK);
        ballLine3.setStrokeWidth(2);

        Group ballGroup = new Group(ball, ballLine1, ballLine2, ballLine3);

        pane.getChildren().addAll(
            floor, centerLine, pole, backboard, rim,
            net1, net2, net3, net4, net5, net6, ballGroup
        );

        Label scoreLabel = new Label("🏀 Score: " + basketballScore + " | Click to Shoot!");
        scoreLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        scoreLabel.setTextFill(Color.YELLOW);
        scoreLabel.setLayoutX(250);
        scoreLabel.setLayoutY(30);
        
        Label powerLabel = new Label("🔋 Power: 0%");
        powerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        powerLabel.setTextFill(Color.LIGHTGREEN);
        powerLabel.setLayoutX(380);
        powerLabel.setLayoutY(70);

        Button back = createButton("⬅ Back", e -> switchScene(buildMainMenu()));
        back.setLayoutX(20);
        back.setLayoutY(20);
        
        pane.getChildren().addAll(scoreLabel, powerLabel, back);

        Scene scene = new Scene(pane, 900, 600);
        
        // Interactive shooting
        final double[] power = {0};
        final boolean[] charging = {false};
        
        Timeline powerCharge = new Timeline(new KeyFrame(Duration.millis(50), e -> {
            if (charging[0]) {
                power[0] = Math.min(power[0] + 2, 100);
                powerLabel.setText("🔋 Power: " + (int)power[0] + "%");
            }
        }));
        powerCharge.setCycleCount(Animation.INDEFINITE);
        
        scene.setOnMousePressed(e -> {
            if (e.getX() < 600) {
                charging[0] = true;
                power[0] = 0;
                powerCharge.play();
            }
        });
        
        scene.setOnMouseReleased(e -> {
            if (charging[0]) {
                charging[0] = false;
                powerCharge.stop();
                
                ball.setCenterX(150);
                ball.setCenterY(450);
                ballLine1.setCenterX(150);
                ballLine1.setCenterY(450);
                ballLine2.setCenterX(150);
                ballLine2.setCenterY(450);
                ballLine3.setStartX(150);
                ballLine3.setStartY(425);
                ballLine3.setEndX(150);
                ballLine3.setEndY(475);
                
                PathTransition shoot = new PathTransition();
                shoot.setDuration(Duration.seconds(1.5 - (power[0] / 100)));
                shoot.setNode(ballGroup);
                
                Path shootPath = new Path();
                shootPath.getElements().add(new MoveTo(150, 450));
                
                double controlY = 100 - (power[0] * 1.5);
                shootPath.getElements().add(new QuadCurveTo(400, controlY, 680, 280));
                
                shoot.setPath(shootPath);
                shoot.setOnFinished(ev -> {
                    double distanceToHoop = Math.abs(ballGroup.getTranslateX() + 150 - 680);
                    if (distanceToHoop < 50) {
                        basketballScore++;
                        scoreLabel.setText("🏀 Score: " + basketballScore + " | SWISH! 🎉");
                        scoreLabel.setTextFill(Color.GOLD);
                    } else {
                        scoreLabel.setText("🏀 Score: " + basketballScore + " | Missed! Try again!");
                        scoreLabel.setTextFill(Color.LIGHTCORAL);
                    }
                    
                    PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
                    pause.setOnFinished(pev -> {
                        ballGroup.setTranslateX(0);
                        ballGroup.setTranslateY(0);
                        scoreLabel.setTextFill(Color.YELLOW);
                        scoreLabel.setText("🏀 Score: " + basketballScore + " | Click to Shoot!");
                    });
                    pause.play();
                });
                
                RotateTransition rotate = new RotateTransition(Duration.seconds(1.5), ballGroup);
                rotate.setByAngle(720);
                
                shoot.play();
                rotate.play();
                
                power[0] = 0;
                powerLabel.setText("🔋 Power: 0%");
            }
        });

        return scene;
    }

    /* ✨ Helper: Fancy Buttons */
    private Button createButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button btn = new Button(text);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        btn.setTextFill(Color.WHITE);
        btn.setStyle("-fx-background-color: linear-gradient(to right, #FF69B4, #FF1493);"
                   + "-fx-background-radius: 30; -fx-padding: 10 25 10 25;");
        btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: linear-gradient(to right, #FF1493, #FF69B4);"
                   + "-fx-background-radius: 30; -fx-padding: 10 25 10 25;"));
        btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: linear-gradient(to right, #FF69B4, #FF1493);"
                   + "-fx-background-radius: 30; -fx-padding: 10 25 10 25;"));
        btn.setOnAction(handler);
        return btn;
    }

    /* 🎬 Scene Transition */
    private void switchScene(Scene newScene) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.6), mainStage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(e -> {
            mainStage.setScene(newScene);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.6), newScene.getRoot());
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fadeOut.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}