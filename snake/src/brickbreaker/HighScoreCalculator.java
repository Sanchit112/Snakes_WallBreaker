package brickbreaker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class HighScoreCalculator
{
	public void Check_highscore(int Rscore,String Rname)
	{ 
		//pass score
		String Gname=Rname;
		int score=Rscore;
		String line=null;
		try 
		{ 
			FileReader fileReader =  new FileReader("HighScore.txt");
       
			try (BufferedReader bufferedReader = new BufferedReader(fileReader)) 
			{
				while((line = bufferedReader.readLine()) != null)
				{
					String[] parts = line.split(":");
					if(parts[0].equals(Gname))
					{    
						int highscore=Integer.parseInt(parts[2]);
						if(score>highscore)
						{
							//input dlg for name
							String Pname=JOptionPane.showInputDialog("Player Name");
							update_high_score(score,Gname,Pname);
						}
					}
                }
			} 
	   	}	
		catch(FileNotFoundException ex){}
		catch(IOException ex){}
}



	public void update_high_score(int Rscore,String gname,String Pname)
	{
		String score=String.valueOf(Rscore);
		String name=Pname;//create dialogue for name
		String gamename=gname;
		String oldFileName = "HighScore.txt";
		String tmpFileName = "tmp_HighScore.txt";
		String newline=gamename+":"+name+":"+score;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			br = new BufferedReader(new FileReader(oldFileName));
			bw = new BufferedWriter(new FileWriter(tmpFileName));
			String line;
			while ((line = br.readLine()) != null)
			{
				String[] parts = line.split(":");
				if (parts[0].equals(gamename))
				{
					line = line.replace(line,newline);
					System.out.println(line);
					System.out.println(newline);
                }
				bw.write(line+"\n");
			}
		}
		catch (IOException ioe) {return;} 
		finally 
		{
			try 
			{
				if(br != null)
					br.close();
			} catch (IOException ioe) {}
			
			try 
			{
				if(bw != null)
					bw.close();
			} catch (IOException ioe) {}
		}
  // Once everything is complete, delete old file..
		JOptionPane.showMessageDialog(null, "Successfull");
		File oldFile = new File(oldFileName);
		oldFile.delete();
 // And rename tmp file's name to old file name
		File newFile = new File(tmpFileName);
		System.out.println("hi");
		newFile.renameTo(oldFile);
		System.exit(0);

}

}