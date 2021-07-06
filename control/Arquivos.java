package control;

import java.io.*;
import model.gestaoProduto.*;

import java.util.List;

public interface Arquivos {

    public default void findAllFilesInFolder(File folder) {
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				System.out.println(file.getName());
			} else {
				findAllFilesInFolder(file);
			}
		}
	}

    public default void findAllFilesInFolder(File folder, List<String> arquivosDeProdutos) {
		// for (File file : folder.listFiles()) {
		// 	if (!file.isDirectory()) {
		// 		System.out.println(file.getName());
        //         arquivosDeProdutos.add(file.getName());
		// 	} else {
		// 		findAllFilesInFolder(file);
		// 	}
		// }
        
        File[] file = folder.listFiles();

        for (int i = 0; i < folder.listFiles().length; i++) {
            if (!file[i].isDirectory()) {
				System.out.println(file[i].getName());
                arquivosDeProdutos.add(file[i].getName());
			} else {
				findAllFilesInFolder(file[i]);
			}
        }
	}

    
    public default void lerArquivo(String caminho) {

        try (

            FileReader acessoArquivo = new FileReader(caminho);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
            
        ) {
            String conteudo = "";

            while (conteudo != null) {
                System.out.println(conteudo);
                conteudo = leitorArquivo.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    // String poderia ser do tipo URL
    public default void escreverArquivo(String caminho, String conteudo) {
        // try-catch wih resources
        try (
            FileWriter acessoArquivo = new FileWriter(caminho, true); // o parâmetro true mantém o conteúdo do arquivo
            BufferedWriter buffer = new BufferedWriter(acessoArquivo);
            PrintWriter escreveArquivo = new PrintWriter(buffer);
            // Não é necessário fechar o arquivo pois ele foi aberto como recurso do try e será fechado automaticamente
        ) {

            escreveArquivo.append(conteudo);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public default void instanciaLivro(Livro livro, String caminhoArquivo)  {
        
        try (
            
            FileReader acessoArquivo = new FileReader(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
            
        ) {

            // Inicializando com a primeira linha do arquivo 
            // que indica o tipo de produto e não é um atributo
            leitorArquivo.readLine();


            livro = new Livro(
            leitorArquivo.readLine(),
            Double.parseDouble(leitorArquivo.readLine()),
            Integer.parseInt(leitorArquivo.readLine()),
            leitorArquivo.readLine(),
            leitorArquivo.readLine(),
            leitorArquivo.readLine(),
            Integer.parseInt(leitorArquivo.readLine()),
            leitorArquivo.readLine(),
            leitorArquivo.readLine());

            // conteudo = leitorArquivo.readLine();
            // livro.setNome(conteudo);;

            // conteudo = leitorArquivo.readLine();
            // livro.setPreco(Double.parseDouble(conteudo));

            // conteudo = leitorArquivo.readLine();
            // livro.setQtdEmEstoque(Integer.parseInt(conteudo));
            
            // conteudo = leitorArquivo.readLine();
            // livro.setISBN(conteudo);
            
            // conteudo = leitorArquivo.readLine();
            // livro.setEditora(conteudo);
            
            // conteudo = leitorArquivo.readLine();
            // livro.setAnoPublicacao(Integer.parseInt(conteudo));
            
            // conteudo = leitorArquivo.readLine();
            // livro.setGenero(conteudo);
            
            // conteudo = leitorArquivo.readLine();
            // livro.setAutor(conteudo);
            
            // conteudo = leitorArquivo.readLine();
            // livro.setCodigo(conteudo);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(livro.getNome());
        System.out.println(livro.getPreco());
        System.out.println(livro.getQtdEmEstoque());
        System.out.println(livro.getISBN());
        System.out.println(livro.getEditora());
        System.out.println(livro.getAnoPublicacao());
        System.out.println(livro.getGenero());
        System.out.println(livro.getAutor());
        System.out.println(livro.getCodigo());
    }

    public default void instanciaHQ(HQ hq, String caminhoArquivo) {
        try (
            FileReader acessoArquivo = new FileReader(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {

            // Inicializando com a primeira linha do arquivo 
            // que indica o tipo de produto e não é um atributo
            String conteudo = leitorArquivo.readLine();

            conteudo = leitorArquivo.readLine();
            hq.setNome(conteudo);
            
            conteudo = leitorArquivo.readLine();
            hq.setPreco(Double.parseDouble(conteudo));
            
            conteudo = leitorArquivo.readLine();
            hq.setQtdEmEstoque(Integer.parseInt(conteudo));
            
            conteudo = leitorArquivo.readLine();
            hq.setISBN(conteudo);
            
            conteudo = leitorArquivo.readLine();
            hq.setEditora(conteudo);

            conteudo = leitorArquivo.readLine();
            hq.setAnoPublicacao(Integer.parseInt(conteudo));
            
            conteudo = leitorArquivo.readLine();
            hq.setGenero(conteudo);
            
            conteudo = leitorArquivo.readLine();
            hq.setAutor(conteudo);

            conteudo = leitorArquivo.readLine();
            hq.setCodigo(conteudo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(hq.getNome());
        System.out.println(hq.getPreco());
        System.out.println(hq.getQtdEmEstoque());
        System.out.println(hq.getISBN());
        System.out.println(hq.getEditora());
        System.out.println(hq.getAnoPublicacao());
        System.out.println(hq.getGenero());
        System.out.println(hq.getAutor());
        System.out.println(hq.getCodigo());
    }

    public default void instanciaRevista(Revista revista, String caminhoArquivo) {
        try (
            FileReader acessoArquivo = new FileReader(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);

        ) {
            // Inicializando com a primeira linha do arquivo 
            // que indica o tipo de produto e não é um atributo
            String conteudo = leitorArquivo.readLine();

            conteudo = leitorArquivo.readLine();
            revista.setNome(conteudo);
            
            conteudo = leitorArquivo.readLine();
            revista.setPreco(Double.parseDouble(conteudo));
            
            conteudo = leitorArquivo.readLine();
            revista.setQtdEmEstoque(Integer.parseInt(conteudo));
            
            conteudo = leitorArquivo.readLine();
            revista.setISBN(conteudo);
            
            conteudo = leitorArquivo.readLine();
            revista.setEditora(conteudo);

            conteudo = leitorArquivo.readLine();
            revista.setAnoPublicacao(Integer.parseInt(conteudo));
            
            conteudo = leitorArquivo.readLine();
            revista.setGenero(conteudo);
            
            conteudo = leitorArquivo.readLine();
            revista.setMarca(conteudo);

            conteudo = leitorArquivo.readLine();
            revista.setCodigo(conteudo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        System.out.println();
        System.out.println(revista.getNome());
        System.out.println(revista.getPreco());
        System.out.println(revista.getQtdEmEstoque());
        System.out.println(revista.getISBN());
        System.out.println(revista.getEditora());
        System.out.println(revista.getAnoPublicacao());
        System.out.println(revista.getGenero());
        System.out.println(revista.getMarca());
        System.out.println(revista.getCodigo());
    }


    public default void instanciaBebida(Bebida bebida, String caminhoArquivo) {
        try (
            FileReader acessoArquivo = new FileReader(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
        ) {
            String conteudo = leitorArquivo.readLine();

            conteudo = leitorArquivo.readLine();
            bebida.setNome(conteudo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public default void instanciaProduto(String caminhoArquivo) {
        
        Livraria produtoFinal;

        try (

            FileReader acessoArquivo = new FileReader(caminhoArquivo);
            BufferedReader leitorArquivo = new BufferedReader(acessoArquivo);
            
        ) {
            String conteudo = "";
                // Lendo o tipo de produto a ser instanciado
                conteudo = leitorArquivo.readLine();

                switch (conteudo.toLowerCase()) {
                    case "livro":
                        produtoFinal = new Livro();
                        instanciaLivro((Livro) produtoFinal, caminhoArquivo);
                        break;
                    case "hq":
                        produtoFinal = new HQ();
                        instanciaHQ((HQ) produtoFinal, caminhoArquivo);
                        break;
                    case "revista":
                        produtoFinal = new Revista();
                        instanciaRevista((Revista) produtoFinal, caminhoArquivo);
                        break;
                    default:
                        break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}