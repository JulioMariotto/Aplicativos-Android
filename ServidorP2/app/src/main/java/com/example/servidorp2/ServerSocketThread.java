package com.example.servidorp2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketThread extends Thread{

    private final Socket socket;


    public ServerSocketThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        try{
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String codAcao = in.readUTF();
            //boolean acao = in.readBoolean();
            int qntd = in.readInt();
            double valorTotal;
            List<Acao> cotacoes = getAcoes();
            for(Acao a : cotacoes){
                if(a.getCodigo().equals(codAcao)){
                    out.writeDouble(a.getValor() * qntd);
                }
            }
            out.flush();
            out.close();
            in.close();
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private List<Acao> getAcoes() {

        List<Acao> list = new ArrayList();
        Acao bra = new Acao("BBDC3", "Bradesco", 29.34);
        list.add(bra);
        Acao pet = new Acao("BRDT3", "Petrobras Distribuidora", 23.87);
        list.add(pet);
        return list;
    }
}
