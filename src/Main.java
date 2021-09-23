import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * O programa Main implementa uma aplicação que
 * lê dados formatados do AirBnb da entrada padrão,
 * processa e imprime o resultado na saida padrão.
 *
 * @author Guilherme Rodrigues
 * @version 0.0.1
 * @since 2021-09-21
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // Lê a primeira linha que é o numero de acomodacoes que seram cadastradas
        line = br.readLine();
        int numDadosAirBnb = Integer.parseInt(line);

        // Sabendo o numero de acomodações lê esse número de acomodações
        Acomodacao[] acomodacoes = new Acomodacao[numDadosAirBnb];
        for (int i = 0; i < numDadosAirBnb; i++) {
            line = br.readLine();
            String[] lineData = line.split("\t", -1);

            // Checa se é uma linha com dados de acomodação
            if (lineData.length == 12) {
                Acomodacao acomodacao = new Acomodacao();
                acomodacao.ler(lineData);
                acomodacoes[i] = acomodacao;
            } else {
                System.err.println("ERRO: Dados em um formato não conhecido");
                return;
            }
        }

        // Le a primeira linha
        line = br.readLine();
        // Checa condicao de parada
        while (!line.equalsIgnoreCase("FIM")) {
            int roomId = Integer.parseInt(line);
            for (int i = 0; i < acomodacoes.length; i++) {
                Acomodacao acomodacao = acomodacoes[i];
                if (roomId == acomodacao.getRoomId()) {
                    acomodacao.imprimir();
                    break;
                }
            }

            // Le a proxima linha
            line = br.readLine();
        }

        // Fechando o BufferedReader que foi aberto
        br.close();
    }

    public static class Acomodacao {
        private int roomId;
        private int hostId;
        private String roomType;
        private String country;
        private String city;
        private String neighbourhood;
        private int reviews;
        private double overallSatisfaction;
        private int accommodates;
        private double bedrooms;
        private double price;
        private String propertyType;

        /**
         * Contrutor vazio para criar uma intância da classe com valores padrão dos atributos
         */
        public Acomodacao() {
        }

        /**
         * Contrutor para criar uma intância da classe com valores para todos os atributos
         */
        public Acomodacao(int roomId, int hostId, String roomType, String country, String city, String neighbourhood, int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price, String propertyType) {
            this.roomId = roomId;
            this.hostId = hostId;
            this.roomType = roomType;
            this.country = country;
            this.city = city;
            this.neighbourhood = neighbourhood;
            this.reviews = reviews;
            this.overallSatisfaction = overallSatisfaction;
            this.accommodates = accommodates;
            this.bedrooms = bedrooms;
            this.price = price;
            this.propertyType = propertyType;
        }

        public void imprimir() {
            String prefix = "[";
            String suffix = "]";
            String separador = " ## ";
            String str = prefix +
                    this.getRoomId() + separador +
                    this.getHostId() + separador +
                    this.getRoomType() + separador +
                    this.getCountry() + separador +
                    this.getCity() + separador +
                    this.getNeighbourhood() + separador +
                    this.getReviews() + separador +
                    this.getOverallSatisfaction() + separador +
                    this.getAccommodates() + separador +
                    this.getBedrooms() + separador +
                    this.getPrice() + separador +
                    this.getPropertyType() +
                    suffix;
            System.out.println(str);
        }

        public void ler(String[] lineData) {
            // TODO: Try catch de conversao de string para numero
            this.setRoomId(Integer.parseInt(lineData[0]));
            this.setHostId(Integer.parseInt(lineData[1]));
            this.setRoomType(lineData[2]);
            this.setCountry(lineData[3]);
            this.setCity(lineData[4]);
            this.setNeighbourhood(lineData[5]);
            this.setReviews(Integer.parseInt(lineData[6]));
            this.setOverallSatisfaction(Double.parseDouble(lineData[7]));
            this.setAccommodates(Integer.parseInt(lineData[8]));
            this.setBedrooms(Double.parseDouble(lineData[9]));
            this.setPrice(Double.parseDouble(lineData[10]));
            this.setPropertyType(lineData[11]);
        }

        public Acomodacao clone() {
            return new Acomodacao(
                    this.getRoomId(),
                    this.getHostId(),
                    this.getRoomType(),
                    this.getCountry(),
                    this.getCity(),
                    this.getNeighbourhood(),
                    this.getReviews(),
                    this.getOverallSatisfaction(),
                    this.getAccommodates(),
                    this.getBedrooms(),
                    this.getPrice(),
                    this.getPropertyType()
            );
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getHostId() {
            return hostId;
        }

        public void setHostId(int hostId) {
            this.hostId = hostId;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getNeighbourhood() {
            return neighbourhood;
        }

        public void setNeighbourhood(String neighbourhood) {
            this.neighbourhood = neighbourhood;
        }

        public int getReviews() {
            return reviews;
        }

        public void setReviews(int reviews) {
            this.reviews = reviews;
        }

        public double getOverallSatisfaction() {
            return overallSatisfaction;
        }

        public void setOverallSatisfaction(double overallSatisfaction) {
            this.overallSatisfaction = overallSatisfaction;
        }

        public int getAccommodates() {
            return accommodates;
        }

        public void setAccommodates(int accommodates) {
            this.accommodates = accommodates;
        }

        public double getBedrooms() {
            return bedrooms;
        }

        public void setBedrooms(double bedrooms) {
            this.bedrooms = bedrooms;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getPropertyType() {
            return propertyType;
        }

        public void setPropertyType(String propertyType) {
            this.propertyType = propertyType;
        }
    }
}
