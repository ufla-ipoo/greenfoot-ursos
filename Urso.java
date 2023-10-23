import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;
import java.util.ArrayList;

/**
 * Urso. Um urso se move para frente até não poder mais, neste ponto
 * ele vira para a esquerda. Se um urso encontra uma folha, ele a come.
 * 
 * Traduzido por Julio César Alves. Versão 2023.10.23
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Urso extends Actor
{
    private static final int LESTE = 0;
    private static final int OESTE = 1;
    private static final int NORTE = 2;
    private static final int SUL = 3;

    private int direcao;
    private int folhasComidas;

    public Urso()
    {
        definirDirecao(LESTE);
        folhasComidas = 0;
    }

    /**
     * Faz o que o urso gostaria de fazer agora.
     */
    public void act()
    {
        if(encontrouFolha()) {
            comerFolha();
        }
        else if(podeSeMover()) {
            mover();
        }
        else {
            virarAEsquerda();
        }
    }

    /**
     * Verifique se tem uma folha na mesma célula onde está o urso.
     */
    public boolean encontrouFolha()
    {
        Actor folha = getOneObjectAtOffset(0, 0, Folha.class);
        if(folha != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Come uma folha.
     */
    public void comerFolha()
    {
        Actor folha = getOneObjectAtOffset(0, 0, Folha.class);
        if(folha != null) {
            // come a folha...
            getWorld().removeObject(folha);
            folhasComidas = folhasComidas + 1; 
        }
    }
    
    /**
     * Move-se uma célula para a frente na direção atual.
     */
    public void mover()
    {
        if (!podeSeMover()) {
            return;
        }
        switch(direcao) {
            case SUL :
                setLocation(getX(), getY() + 1);
                break;
            case LESTE :
                setLocation(getX() + 1, getY());
                break;
            case NORTE :
                setLocation(getX(), getY() - 1);
                break;
            case OESTE :
                setLocation(getX() - 1, getY());
                break;
        }
    }

    /**
     * Verifica se o urso pode se mover. Reotrna true se pode e false em caso contrário.
     */
    public boolean podeSeMover()
    {
        World mundo = getWorld();
        int x = getX();
        int y = getY();
        switch(direcao) {
            case SUL :
                y++;
                break;
            case LESTE :
                x++;
                break;
            case NORTE :
                y--;
                break;
            case OESTE :
                x--;
                break;
        }
        // testa se está fora da borda
        if (x >= mundo.getWidth() || y >= mundo.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    /**
     * Vira à esquerda.
     */
    public void virarAEsquerda()
    {
        switch(direcao) {
            case SUL :
                definirDirecao(LESTE);
                break;
            case LESTE :
                definirDirecao(NORTE);
                break;
            case NORTE :
                definirDirecao(OESTE);
                break;
            case OESTE :
                definirDirecao(SUL);
                break;
        }
    }

    /**
     * Define a direção para onde estamos olhando.
     */
    public void definirDirecao(int direcao)
    {
        this.direcao = direcao;
        switch(direcao) {
            case SUL :
                setRotation(90);
                break;
            case LESTE :
                setRotation(0);
                break;
            case NORTE :
                setRotation(270);
                break;
            case OESTE :
                setRotation(180);
                break;
            default :
                break;
        }
    }

    /**
     * Diz quantas folhas foram comidas.
     */
    public int obterFolhasComidas()
    {
        return folhasComidas;
    }
}