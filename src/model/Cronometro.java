package model;

public class Cronometro extends MyThread{

	private int minutos, segundos, milesimas;

	@Override
	void executeTask() {
		//min es minutos, seg es segundos y mil es milesimas de segundo
		try
		{
			//Mientras cronometroActivo sea verdadero entonces seguira
			//aumentando el tiempo
			Thread.sleep( 4 );
			//Incrementamos 4 milesimas de segundo
			milesimas += 4;

			//Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
			//y las milesimas de segundo de nuevo a 0
			if( milesimas == 1000 )
			{
				milesimas = 0;
				segundos += 1;
				//Si los segundos llegan a 60 entonces aumenta 1 los minutos
				//y los segundos vuelven a 0
				if( segundos == 60 )
				{
					segundos = 0;
					minutos++;
				}
			}
		}catch(Exception e){}
	}

	public void resetCronometro() {
		this.minutos = 0;
		this.segundos = 0;
		this.milesimas = 0;
	}
	
	public String getTotalTime() {
		return minutos + ":" + segundos + ":" + milesimas;
	}

	public int getTotalInMiliseconds() {
		int total = minutos * 60000;
		total += segundos * 1000;
		total += milesimas;
		return total;
	}
}
