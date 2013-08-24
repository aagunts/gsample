

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Revolver {

	private List<Boolean> danso;
	private int num;
	private int position;

	/**
	 * コンストラクタ
	 * @param num
	 */
	public Revolver(int num) {
		this.num = num;
		danso = new LinkedList();

		for(int i = 0; i < num; i++) {
			danso.add(false);
		}
		turn();
	}

	/**
	 * 弾倉のターン
	 */
	public void turn() {
		Random rnd = new Random();
		position = rnd.nextInt(num);
	}

	/**
	 * 銃を撃つ
	 */
	public boolean shot() {
		boolean result;
		result = danso.get(position);
		danso.set(position, false);

		if ( result ) {
			System.out.println(position + " Shot!!");
		} else {
			System.out.println(position + " Kachi!!");
		}

		positionChange();
		return result;
	}

	/**
	 * 弾込め
	 * @param bulletCnt
	 */
	public void setBullet(int bulletCnt) {
		for (int i=0; i < bulletCnt; i++ ) {
			danso.set(position, true);
			positionChange();
		}
	}

	public void show() {
		for(boolean bullet : danso) {
			System.out.print(bullet + " ");
		}
		System.out.println();
	}

	/**
	 * ポジションの変更
	 */
	private void positionChange() {
		position++;
		if (num <= position ) {
			position = 0;
		}
	}

}
