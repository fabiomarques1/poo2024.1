package modelo;

import java.util.Objects;

public class Lutador {
    private int codigo;
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso ;
    private String categoria;
    private int vitorias;
    private int derrotas ;
    private int empates;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.nacionalidade);
        hash = 97 * hash + this.idade;
        hash = 97 * hash + Float.floatToIntBits(this.altura);
        hash = 97 * hash + Float.floatToIntBits(this.peso);
        hash = 97 * hash + Objects.hashCode(this.categoria);
        hash = 97 * hash + this.vitorias;
        hash = 97 * hash + this.derrotas;
        hash = 97 * hash + this.empates;
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
        final Lutador other = (Lutador) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (Float.floatToIntBits(this.altura) != Float.floatToIntBits(other.altura)) {
            return false;
        }
        if (Float.floatToIntBits(this.peso) != Float.floatToIntBits(other.peso)) {
            return false;
        }
        if (this.vitorias != other.vitorias) {
            return false;
        }
        if (this.derrotas != other.derrotas) {
            return false;
        }
        if (this.empates != other.empates) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        return Objects.equals(this.categoria, other.categoria);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        if (this.peso >= 100) {
            this.categoria = "Peso Pesado";
        } else if (this.peso >= 80) {
            this.categoria = "Peso Médio";
        } else {
            this.categoria = "Peso Leve";
        }
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
