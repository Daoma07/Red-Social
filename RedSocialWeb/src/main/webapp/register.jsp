<%-- 
    Document   : register
    Created on : 29/06/2023, 03:55:06 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="resources/css/register.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <!--<header>Create Your Account</header>-->
            <div class="progress">
                <div class="Step">
                    <p></p>
                </div>
            </div>
            <div class="form-outer">
                <form action="#">
                    <div class="page slidepage">
                        <div class="title">Create Your Account</div>
                        <div class="field">
                            <div class="label">Nombre</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Apellido Paterno</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Apellido Materno</div>
                            <input type="text">
                        </div>
                        <div class="field nextBtn">
                            <button>Siguiente</button>
                        </div>
                    </div>

                    <div class="page">
                        <div class="title">Contact Info:</div>
                        <div class="field">
                            <div class="label">Correo Electrónico</div>
                            <input type="email">
                        </div>
                        <div class="field">
                            <div class="label">Número Telefónico</div>
                            <input type="tel">
                        </div>
                        <div class="field buttons">
                            <button class="prev-1 prev">Anterior</button>
                            <button class="next-1 next">Siguiente</button>
                        </div>
                    </div>

                    <div class="page">
                        <div class="title">More Contact Info:</div>
                        <div class="field">
                            <div class="label">Estado</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Ciudad</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Municipio</div>
                            <input type="text">
                        </div>
                        <div class="field buttons">
                            <button class="prev-2 prev">Anterior</button>
                            <button class="next-2 next">Siguiente</button>
                        </div>
                    </div>

                    <div class="page">
                        <div class="title">Date of Birth:</div>
                        <div class="field">
                            <div class="label">Fecha Nacimiento</div>
                            <input type="date">
                        </div>
                        <div class="field">
                            <div class="label">Género</div>
                            <select>
                                <option value="hombre">Hombre</option>
                                <option value="mujer">Mujer</option>
                            </select>
                        </div>
                        <div class="field buttons">
                            <button class="prev-3 prev">Anterior</button>
                            <button class="next-3 next">Siguiente</button>
                        </div>
                    </div>

                    <div class="page">
                        <div class="title">LogIn Details:</div>
                        <div class="field">
                            <div class="label">Nombre Usuario</div>
                            <input type="text">
                        </div>
                        <div class="field">
                            <div class="label">Contraseña</div>
                            <input type="password">
                        </div>
                        <div class="field buttons">
                            <button class="prev-4 prev">Anterior</button>
                            <button class="submit next">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="script.js"></script>

    </body>
</html>