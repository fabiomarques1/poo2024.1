package modelo;

import java.util.Date;
import java.util.Objects;

public class Luta {
    private int codigo;
    private Date dataHora;
    private Lutador desafiado;
    private Lutador desafiante;
    private int partidas;
    private boolean aprovada;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.dataHora);
        hash = 59 * hash + Objects.hashCode(this.desafiado);
        hash = 59 * hash + Objects.hashCode(this.desafiante);
        hash = 59 * hash + this.partidas;
        hash = 59 * hash + (this.aprovada ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Luta other = (Luta) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.partidas != other.partidas) {
            return false;
        }
        if (this.aprovada != other.aprovada) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (!Objects.equals(this.desafiado, other.desafiado)) {
            return false;
        }
        return Objects.equals(this.desafiante, other.desafiante);
    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Luta{");
        sb.append("codigo=").append(codigo);
        sb.append(", dataHora=").append(dataHora);
        sb.append(", desafiado=").append(desafiado);
        sb.append(", desafiante=").append(desafiante);
        sb.append(", partidas=").append(partidas);
        sb.append(", aprovada=").append(aprovada);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
