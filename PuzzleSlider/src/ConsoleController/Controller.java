package ConsoleController;

import java.util.Scanner;

import Engine.Engine;
import ExceptionHandling.InvalidArgumentException;

public class Controller {

	protected Engine mEngine;
	protected boolean mQuitFlag = false;
	
	protected void PrintHelp() {
		System.out.println(" Usage: ");
		System.out.println(" help - prints this help message");
		System.out.println(" quit - quits the program");
		System.out.println(" newgame - initialized new 4x4 game");
		System.out.println(" X Y - make a move (move empty space to this position), where X (row), Y (column) are numbers");
	}
	
	protected void PrintStartScreen() {
		System.out.println("Welcome to Puzzle Slider");
		PrintHelp();
	}
	
	protected void NewGame() {
		try {
			mEngine = new Engine(4);
			System.out.println("New game started");
			System.out.print(mEngine);
			
		} catch ( InvalidArgumentException e){
			System.out.println( "someone fucked up :)" );
		}
	}
	
	protected void Process( String input ) {
		input = input.toLowerCase();
		switch (input) {
		case "quit":
			mQuitFlag = true;
			System.out.println("Thank you for playing!");
			break;
		case "help":
			PrintHelp();
			break;
		case "newgame":
			NewGame();
			break;
		default:
			String[] nums = input.split(" ");
			if ( nums.length == 2) {
				try {
					Integer row = Integer.parseInt(nums[0], 10) - 1;
					Integer column = Integer.parseInt(nums[1], 10) - 1;
					boolean validMove = mEngine.move( row, column );
					if ( !validMove ) {
						System.out.println("Invalid move");
					} else {
						if ( mEngine.isFinished() ) {
							System.out.println("Congratulations!");
							mEngine = null;
						} else {
							System.out.print(mEngine);
						}
					}
				} catch ( NumberFormatException e) {
					PrintHelp();
				} catch ( NullPointerException e) {
					if ( mEngine == null ) {
						System.out.println("Use \"newgame\" command please");
					} else {
						throw e;
					}
				}
			}
			
			break;
		}
	}
	
	protected void InitializeLoop() {
		Scanner inputStream = new Scanner( System.in );
		String input;
		
		while ( !mQuitFlag ) {
			System.out.print("> ");
			input = inputStream.nextLine();
			Process( input );
		}
		
		inputStream.close();
	}
	
	public void Start() {
		PrintStartScreen();
		InitializeLoop();
		
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.Start();
	}
	
}
