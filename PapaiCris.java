package Cr7;
import robocode.*;
import java.awt.Color;

/**
 * PapaiCris - a robot by Guilherme Viana 
 */
/**
 * PapaiCris - a sample robot by Guilherme Viana.
 * <p>
 * This robot moves on walls.
 */

public class PapaiCris extends Robot
{
	boolean peek;
	double moveAmount; 

	public void run() {
		setBodyColor(Color.black);
		setGunColor(Color.black);
		setRadarColor(Color.white);
		setBulletColor(Color.red);
		// Captura o tamanho do campo de batalha.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		peek = false;// Começa não verificando
		// Vira a esquerda para ir até a parede.
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		// Movimenta a mira e o eixo para direita e ativa a verificação.
		peek = true;
		turnGunRight(90);
		turnRight(90);
		int cont = 0;
		while (true) {	
			peek = true;// Verifica até movimentar pela parede
			ahead(moveAmount);// Move pela parede
			cont++;
			turnRight(90);// Vira para proxima parede
			if (cont % 2 == 0) { // alterna a cor quando anda na parede
			setBodyColor(Color.black);
			setGunColor(Color.black);
			setRadarColor(Color.white);
			setBulletColor(Color.red);
			} else {
			setBodyColor(Color.white);
			setGunColor(Color.white);
			setRadarColor(Color.black);
			setBulletColor(Color.blue);	
			}
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {

	 double distance = e.getDistance(); //Pega a distância
    if(distance > 800) //reajusta a força
        fire(5);
    else if(distance > 600 && distance <= 800)
        fire(5);
    else if(distance > 400 && distance <= 600)
        fire(3);
    else if(distance > 200 && distance <= 400)
        fire(2);
    else if(distance < 200)
        fire(2);

	scan();
		

	}

	public void onHitRobot(HitRobotEvent e) {
	
		if (e.getBearing() > -90 && e.getBearing() < 90) {// Se estiver proximo 
			scan();
			back(100);
		} 
		else { // Se estiver longe
			scan();
			ahead(100);
		}
	}
	
	public void onWin(WinEvent e) {
		for (int i = 0; i < 50; i++) {
			fire(1);
			turnRight(360);
			fire(1);
			turnLeft(360);
			fire(1);
		}
	}

}
	

