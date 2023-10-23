import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

/**
 * Um mundo onde ursos vivem.
 * 
 * Traduzido por Julio César Alves. Versão 2023.10.23
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class MundoDoUrso extends World
{
    /**
     * Cria um novo mundo com 8x8 células, com
     * células de tamanho 60x60 pixels
     */
    public MundoDoUrso() 
    {
        super(8, 8, 60);        
        setBackground("celula.jpg");
    }

    /**
     * Povoa o mundo com um cenário fixo de ursos e folhas.
     */    
    public void povoar()
    {
        Urso u1 = new Urso();
        addObject(u1, 3, 3);
        
        Urso u2 = new Urso();
        addObject(u2, 1, 7);

        Folha f1 = new Folha();
        addObject(f1, 5, 3);

        Folha f2 = new Folha();
        addObject(f2, 0, 2);

        Folha f3 = new Folha();
        addObject(f3, 7, 5);

        Folha f4 = new Folha();
        addObject(f4, 2, 6);

        Folha f5 = new Folha();
        addObject(f5, 5, 0);
        
        Folha f6 = new Folha();
        addObject(f6, 4, 7);
    }
    
    /**
     * Coloca uma quantidade de folhas no mundo em lugares aleatórios.
     * O número de folhas pode ser informado.
     */
    public void folhasAleatorias(int quantas)
    {
        for(int i = 0; i < quantas; i++) {
            Folha Folha = new Folha();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(Folha, x, y);
        }
    }
}