package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class ImplementacaoService {

  public void mentoria() {

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    Bootcamp bootcamp = new Bootcamp();
    System.out.println("\n**************** Bem vindo a nossa área virtual *******************\n");

    System.out.println("===========  Vamos criar um Bootcamp ===============\n");
    System.out.println("Digite um nome para o Bootcamp: ");
    String bootCampNmae = scanner.nextLine();
    System.out.println("Escreva uma descrição para o Bootcamp: ");
    String bootcampDescription = scanner.nextLine();
    bootcamp.setNome(bootCampNmae);
    bootcamp.setDescricao(bootcampDescription);

    System.out.println("Quantos cursos quer inserir no sistema? ");
    int qtdCursos = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < qtdCursos; i++) {

      System.out.println("Digite o nome do curso " + (i + 1));
      String name = scanner.nextLine();
      System.out.println("Digite uma descrição para " + name);
      String description = scanner.nextLine();
      System.out.println("Digite a carga horária deste curso:");
      int carH = scanner.nextInt();
      scanner.nextLine();
      Curso curso1 = new Curso(name, description, carH);
      bootcamp.getConteudos().add(curso1);
    }

    System.out.println("Quantas mentorias quer inserir no sistema?");
    int qdtMentorias = scanner.nextInt();
    scanner.nextLine();

    for (int j = 0; j < qdtMentorias; j++) {
      System.out.println("Digite o nome da mentoria:");
      String name = scanner.nextLine();
      System.out.println("Digite uma descrição para a mentoria:");
      String description = scanner.nextLine();

      Mentoria mentoria = new Mentoria(name, description, LocalDate.now());
      bootcamp.getConteudos().add(mentoria);
    }

    System.out.println("Quantos Dev's quer inserir no Sistema? ");
    int qdtDevs = scanner.nextInt();
    scanner.nextLine();

    for (int k = 0; k < qdtDevs; k ++) {
      Dev dev = new Dev();
      System.out.println("Nome do Dev:");
      String nameDev = scanner.nextLine();
      dev.setNome(nameDev);
      dev.inscreverBootcamp(bootcamp);
      System.out.println("Conteúdos Inscritos " + dev.getNome() + dev.getConteudosInscritos());
      dev.progredir();
      dev.progredir();
      dev.progredir();
      System.out.println("-");
      System.out.println("Conteúdos Inscritos " + dev.getNome() + dev.getConteudosInscritos());
      System.out.println("Conteúdos Concluidos " + dev.getNome() + dev.getConteudosConcluidos());
      System.out.println("XP:" + dev.calcularTotalXp());
    }
  }
}
