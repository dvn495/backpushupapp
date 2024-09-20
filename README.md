## Endpoints Comunes

Cada controlador sigue un patrón común para CRUD de sus respectivas entidades. A continuación, se explica el funcionamiento general de cada endpoint:

### 1. `GET /{entity}`
- **Descripción**: Recupera todas las instancias de la entidad `{entity}`.
- **Respuesta**: 
  - **200 OK**: Devuelve una lista con todas las instancias de la entidad.
  - Ejemplo de uso:
    ```
    GET /Paises
    GET /Categorias
    ```

### 2. `GET /{entity}/{id}`
- **Descripción**: Recupera una instancia específica de la entidad por su ID.
- **Parámetros**:
  - `id`: El ID de la entidad que se quiere obtener.
- **Respuesta**:
  - **200 OK**: Devuelve la entidad encontrada.
  - **404 Not Found**: Si no se encuentra la entidad.
  - Ejemplo de uso:
    ```
    GET /Paises/1
    GET /Categorias/3
    ```

### 3. `POST /{entity}`
- **Descripción**: Crea una nueva instancia de la entidad.
- **Cuerpo de la petición**: El cuerpo debe ser un objeto JSON válido representando la nueva instancia.
- **Respuesta**:
  - **201 Created**: La entidad fue creada exitosamente.
  - Ejemplo de uso:
    ```
    POST /Paises
    {
      "nombre": "Argentina"
    }
    ```

### 4. `PUT /{entity}/{id}`
- **Descripción**: Actualiza una instancia existente de la entidad por su ID.
- **Parámetros**:
  - `id`: El ID de la entidad a actualizar.
- **Cuerpo de la petición**: El cuerpo debe contener los datos actualizados en formato JSON.
- **Respuesta**:
  - **200 OK**: La entidad fue actualizada exitosamente.
  - **404 Not Found**: Si no se encuentra la entidad.
  - Ejemplo de uso:
    ```
    PUT /Paises/1
    {
      "nombre": "Brasil"
    }
    ```

### 5. `DELETE /{entity}/{id}`
- **Descripción**: Elimina una instancia específica de la entidad por su ID.
- **Parámetros**:
  - `id`: El ID de la entidad a eliminar.
- **Respuesta**:
  - **200 OK**: La entidad fue eliminada exitosamente.
  - **404 Not Found**: Si no se encuentra la entidad.
  - Ejemplo de uso:
    ```
    DELETE /Paises/1
    ```

## Lista de Entidades y sus Rutas

1. **Paises**  
   - **Base URL**: `/Paises`

2. **Regiones**  
   - **Base URL**: `/Regiones`

3. **Ciudades**  
   - **Base URL**: `/Ciudades`

4. **Empresa**  
   - **Base URL**: `/Empresa`

5. **Categorias**  
   - **Base URL**: `/Categorias`

6. **Epocaantiguedad**  
   - **Base URL**: `/Epocaantiguedad`

7. **Rankingantiguedad**  
   - **Base URL**: `/Rankingantiguedad`

8. **Galeria**  
   - **Base URL**: `/Galeria`

9. **Genero**  
   - **Base URL**: `/Genero`

10. **Estadopersona**  
    - **Base URL**: `/Estadopersona`

11. **Persona**  
    - **Base URL**: `/Persona`

12. **Sucursal**  
    - **Base URL**: `/Sucursal`

13. **Antiguedades**  
    - **Base URL**: `/Antiguedades`

14. **Clasecontacto**  
    - **Base URL**: `/Clasecontacto`

15. **Contactopersona**  
    - **Base URL**: `/Contactopersona`

16. **Tipodireccion**  
    - **Base URL**: `/Tipodireccion`

17. **Direccionpersona**  
    - **Base URL**: `/Direccionpersona`

18. **Coleccionistas**  
    - **Base URL**: `/Coleccionistas`

19. **TipoPersona**  
    - **Base URL**: `/TipoPersona`

20. **Personatipopersona**  
    - **Base URL**: `/Personatipopersona`

21. **Historialpropiedad**  
    - **Base URL**: `/Historialpropiedad`

22. **Tipotransaccion**  
    - **Base URL**: `/Tipotransaccion`

23. **Mediopago**  
    - **Base URL**: `/Mediopago`

24. **Transaccionmediopago**  
    - **Base URL**: `/Transaccionmediopago`

25. **Tipomovcaja**  
    - **Base URL**: `/Tipomovcaja`

26. **Movcaja**  
    - **Base URL**: `/Movcaja`

27. **Estacionpago**  
    - **Base URL**: `/Estacionpago`

28. **Transacciones**  
    - **Base URL**: `/Transacciones`

29. **Empleados**  
    - **Base URL**: `/Empleados`

30. **DetalleTransaccion**  
    - **Base URL**: `/DetalleTransaccion`

31. **Despachos**  
    - **Base URL**: `/Despachos`

