package Engine;

import java.io.Serializable;
import java.util.Arrays;

import ExceptionHandling.InvalidArgumentException;
import ExceptionHandling.UnitionalizedGameException;

public class GameState implements Serializable {

	private static final long serialVersionUID = 9121546843854872241L;
	protected int[][] mTiles;
	protected int mState;
	protected int mSize;


	public GameState(int size) throws InvalidArgumentException{
		if (size < 4) {
			throw new InvalidArgumentException();
		}
		mState = Constants.GS_UNINITIALIZED;
		mSize = size;
		initialize();
	}
	
	
	public void switchTiles(int firstRow, int firstCol, int secondRow, int secondCol){
//		TODO
	}

	private void initialize(){
		mTiles = new int[mSize][mSize];
		for (int row = 0; row < mTiles.length; row++) {
			for (int col = 0; col < mTiles.length; col++) {
				mTiles[row][col] = row*mSize + col + 1;
			}
		}
		mTiles[mSize-1][mSize-1] = 0;
	}
	

	@Override
	public String toString() {
		if(mState == Constants.GS_UNINITIALIZED){
			return "GAME NOT INITIONALIZED.";
		}
		return Arrays.deepToString(mTiles);
	}

	public int[][] getmTiles() {
		return mTiles;
	}

	public int getSpecificTile(int row, int col) throws UnitionalizedGameException, InvalidArgumentException{
		if(mState == Constants.GS_UNINITIALIZED){
			throw new UnitionalizedGameException();
		}

		if (row >= mSize || col >= mSize) {
			throw new InvalidArgumentException();
		}

		return mTiles[row][col];
	}

	public int getmState() {
		return mState;
	}

	public void setmState(int mState) {
		this.mState = mState;
	}

	public int getmSize() {
		return mSize;
	}

}

