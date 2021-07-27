import java.util.ArrayList;

class Garden
{
    public Feld[][][] garten;
    private Akasha[] akashas=new Akasha[4];
    public Garden(int a, int b, int c)
    {
        garten=new Feld[a][b][c];
    }

    private void checkfeld(int a, int b, int c)
    {
        if(garten[a][b][c]==null) garten[a][b][c]=new Feld();
    }

    public void akashaHinzufuegen(Akasha a, int pos)
    {
        if(akashas[pos]==null)akashas[pos]=a;
        else System.out.println("Platz besetzt.");
    }

    public void akashaEntfernen(int pos)
    {
        if(akashas[pos]!=null)akashas[pos]=null;
    }
}
