link a mi repositorio: https://github.com/pablonso308/NovelaManager.git

Informe Detallado: Aplicación de Gestión de Novelas
Introducción
La aplicación de gestión de novelas es una solución diseñada para ayudar a los usuarios a gestionar su colección de novelas de manera eficiente. Permite a los usuarios agregar, eliminar, y ver detalles de las novelas, así como marcar sus novelas favoritas y agregar reseñas. La aplicación utiliza el patrón de arquitectura MVVM (Modelo-Vista-VistaModelo) y Room para la gestión de la base de datos, lo que la hace escalable y fácil de mantener.

Funcionalidades Clave
1. Agregar Novelas
Permite a los usuarios ingresar detalles sobre nuevas novelas, incluyendo:
Título
Autor
Año de publicación
Sinopsis
Se utiliza un cuadro de diálogo (DialogFragment) para facilitar la entrada de datos.
2. Eliminar Novelas
Los usuarios pueden eliminar novelas de su lista.
La funcionalidad de eliminación se implementa en el adaptador de la lista, donde se puede hacer clic en una novela y eliminarla.
3. Ver Detalles de las Novelas
Al seleccionar una novela, se muestran detalles completos que incluyen el título, autor, año de publicación, sinopsis y la opción de marcarla como favorita.
4. Marcar Novelas Favoritas
Los usuarios pueden marcar novelas como favoritas, que se destacan visualmente en la lista principal.
5. Agregar Reseñas
Los usuarios pueden agregar reseñas para cada novela, lo que les permite recordar sus pensamientos y opiniones sobre la obra.
6. Interfaz de Usuario Intuitiva
Se implementa una interfaz amigable y fácil de usar, organizada mediante ConstraintLayout y RecyclerView.
Arquitectura de la Aplicación
La aplicación sigue el patrón de arquitectura MVVM (Modelo-Vista-VistaModelo), lo que permite una separación clara entre la lógica de negocio y la interfaz de usuario.

1. Modelo
Clases de Modelo: La clase Novel representa la estructura de datos para cada novela.
Base de Datos: Se utiliza Room como ORM (Object-Relational Mapping) para manejar la base de datos local.
NovelDatabase: Clase principal para gestionar la base de datos.
NovelDao: Interfaz para definir métodos de acceso a la base de datos.
NovelRepository: Maneja la lógica de acceso a datos y realiza operaciones CRUD.
2. Vista
Actividades y Fragmentos: Utiliza MainActivity y DialogFragment para mostrar la interfaz al usuario.
Layouts XML: Define la estructura visual de la interfaz, utilizando ConstraintLayout y RecyclerView para la presentación de las novelas.
3. VistaModelo
NovelViewModel: Intermediario entre la vista y el modelo. Proporciona datos a la vista y responde a las acciones del usuario.
Estructura del Código
1. MainActivity
Controla la lógica principal de la aplicación y configura la interfaz de usuario inicial.
Se encarga de la gestión de eventos, como la adición de nuevas novelas.
java
Copiar código
public class MainActivity extends AppCompatActivity {
    // Variables de UI
    private Button buttonAddBook;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private NovelAdapter novelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Configuración de la actividad y la vista
    }

    // Lógica para agregar novela
}
2. Novel (Modelo)
Representa la información de cada novela.
Contiene campos como title, author, year, y synopsis.
3. NovelDao (Acceso a Datos)
Define métodos para operaciones CRUD sobre la base de datos.
Anotaciones como @Insert, @Delete y @Query se utilizan para especificar las acciones.
4. NovelViewModel
Actúa como un puente entre el modelo y la vista.
Proporciona datos y maneja acciones del usuario, como agregar o eliminar novelas.
5. Adaptador de Novelas (NovelAdapter)
Maneja la representación visual de la lista de novelas en el RecyclerView.
Configura la vista de cada ítem y maneja eventos como clics para eliminar o ver detalles.
Diseño de Interfaz de Usuario
1. Activity Layout
Se utiliza un ConstraintLayout que contiene un Button para agregar novelas y un RecyclerView para mostrar la lista de novelas.
xml
Copiar código
<androidx.constraintlayout.widget.ConstraintLayout>
    <Button android:id="@+id/buttonAddBook"/>
    <androidx.recyclerview.widget.RecyclerView android:id="@+id/recyclerView"/>
</androidx.constraintlayout.widget.ConstraintLayout>
2. DialogFragment para Agregar Novelas
Un cuadro de diálogo que permite la entrada de datos para nuevas novelas, con campos para título, autor, año y sinopsis.
xml
Copiar código
<LinearLayout>
    <EditText android:id="@+id/editTextTitle"/>
    <EditText android:id="@+id/editTextAuthor"/>
    <EditText android:id="@+id/editTextYear" android:inputType="number"/>
    <EditText android:id="@+id/editTextSynopsis"/>
</LinearLayout>
