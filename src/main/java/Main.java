import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";


    private static final String Tomsk_KEY = "290868";
    private static final String API_KEY = "N2EJQHAsHVR9AOkkZO9eLRBKk3dvOAr2";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(Tomsk_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        // При необходимости указать заголовки
        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();

        int firstIndexBody = jsonResponse.indexOf("[{\"Date\"");
        int lastIndexBody = jsonResponse.lastIndexOf("}");
        jsonResponse = jsonResponse.substring(firstIndexBody, lastIndexBody);

        ObjectMapper om = new ObjectMapper();

        List<WeatherResponse> weatherResponseList = om.readValue(jsonResponse, new TypeReference<List<WeatherResponse>>() {});

        for (WeatherResponse weather: weatherResponseList) {
            System.out.println("В городе Томск на следующую дату " + weather.getDate().substring(0, 10) +
                    " ожидается такая погода: Минимальная температура " + weather.getTemperature().getMinimum().getValue() + "°С. Максимальная температура " +
                    weather.getTemperature().getMaximum().getValue() + "°С. Днём - " + weather.getDay().getIconPhrase() + ". Ночью - " + weather.getNight().getIconPhrase() + ".");
        }
    }
}
