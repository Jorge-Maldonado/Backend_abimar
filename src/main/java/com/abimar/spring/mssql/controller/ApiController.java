package com.abimar.spring.mssql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.abimar.spring.mssql.model.*;
import com.abimar.spring.mssql.repository.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    BitacoraRepository bitacoraRepository;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    DireccionRepository direccionRepository;
    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    RolRepository rolRepository;
    @Autowired
    PermisosRepository permisosRepository;
    @Autowired
    ModuloRepository moduloRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ImagenRepository imagenRepository;
    @Autowired
    DetallePedidoRepository detallePedidoRepository;
    @Autowired
    DetalleTempRepository detalleTempRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    TipoPagoRepository tipoPagoRepository;
    @Autowired
    ReembolsoRepository reembolsoRepository;
    @Autowired
    SuscripcionesRepository suscripcionesRepository;
    @Autowired
    ContactoRepository contactoRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmailUser(request.getEmailUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.ok("Login correcto");
        } else {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }
    }


    // 1------------------ USUARIO -----------------------
    @PostMapping("/usuario/create")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        try {
            String hashedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(hashedPassword);
            Usuario _usuario = usuarioRepository.save(usuario);
            return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/usuario/read")
    public ResponseEntity<Usuario> readUsuario(@RequestParam Long id) {
        Optional<Usuario> usuarioData = usuarioRepository.findById(id);
        if (usuarioData.isPresent()) {
            return new ResponseEntity<>(usuarioData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/usuario/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioData = usuarioRepository.findById(usuario.getIdusuario());
        if (usuarioData.isPresent()) {
            Usuario _usuario = usuarioData.get();
            _usuario.setEmailUser(usuario.getEmailUser());
            _usuario.setPassword(usuario.getPassword());
            _usuario.setToken(usuario.getToken());
            _usuario.setPersonal(usuario.getPersonal());
            usuarioRepository.save(_usuario);
            return new ResponseEntity<>(_usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/usuario/delete")
    public ResponseEntity<HttpStatus> deleteUsuario(@RequestParam Long id) {
        try {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2------------------ BITACORA -----------------------
    @PostMapping("/bitacora/create")
    public ResponseEntity<Bitacora> createBitacora(@RequestBody Bitacora bitacora) {
        try {
            Bitacora _bitacora = bitacoraRepository.save(bitacora);
            return new ResponseEntity<>(_bitacora, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/bitacora/read")
    public ResponseEntity<Bitacora> readBitacora(@RequestParam Long id) {
        Optional<Bitacora> bitacoraData = bitacoraRepository.findById(id);
        if (bitacoraData.isPresent()) {
            return new ResponseEntity<>(bitacoraData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/bitacora/update")
    public ResponseEntity<Bitacora> updateBitacora(@RequestBody Bitacora bitacora) {
        Optional<Bitacora> bitacoraData = bitacoraRepository.findById(bitacora.getIdbitacora());
        if (bitacoraData.isPresent()) {
            Bitacora _bitacora = bitacoraData.get();
            _bitacora.setAccion(bitacora.getAccion());
            _bitacora.setDatecreate(bitacora.getDatecreate());
            _bitacora.setIdusuario(bitacora.getIdusuario());
            bitacoraRepository.save(_bitacora);
            return new ResponseEntity<>(_bitacora, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/bitacora/delete")
    public ResponseEntity<HttpStatus> deleteBitacora(@RequestParam Long id) {
        try {
            bitacoraRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 3------------------ PERSONA -----------------------
    @PostMapping("/persona/create")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        try {
            Persona _persona = personaRepository.save(persona);
            return new ResponseEntity<>(_persona, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/persona/read")
    public ResponseEntity<Persona> readPersona(@RequestParam Long id) {
        Optional<Persona> personaData = personaRepository.findById(id);
        if (personaData.isPresent()) {
            return new ResponseEntity<>(personaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persona/update")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
        Optional<Persona> personaData = personaRepository.findById(persona.getIdpersona());
        if (personaData.isPresent()) {
            Persona _persona = personaData.get();
            _persona.setIdentificacion(persona.getIdentificacion());
            _persona.setNombres(persona.getNombres());
            _persona.setApellidos(persona.getApellidos());
            _persona.setTelefono(persona.getTelefono());
            _persona.setDocumento(persona.getDocumento());
            _persona.setRazonSocial(persona.getRazonSocial());
            _persona.setRolId(persona.getRolId());
            _persona.setFechaCreacion(persona.getFechaCreacion());
            _persona.setEstado(persona.getEstado());
            _persona.setTipoDocumentoId(persona.getTipoDocumentoId());
            personaRepository.save(_persona);
            return new ResponseEntity<>(_persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persona/delete")
    public ResponseEntity<HttpStatus> deletePersona(@RequestParam Long id) {
        try {
            personaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 4------------------ DIRECCION -----------------------
    @PostMapping("/direccion/create")
    public ResponseEntity<Direccion> createDireccion(@RequestBody Direccion direccion) {
        try {
            Direccion _direccion = direccionRepository.save(direccion);
            return new ResponseEntity<>(_direccion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/direccion/read")
    public ResponseEntity<Direccion> readDireccion(@RequestParam Long id) {
        Optional<Direccion> direccionData = direccionRepository.findById(id);
        if (direccionData.isPresent()) {
            return new ResponseEntity<>(direccionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/direccion/update")
    public ResponseEntity<Direccion> updateDireccion(@RequestBody Direccion direccion) {
        Optional<Direccion> direccionData = direccionRepository.findById(direccion.getIddireccion());
        if (direccionData.isPresent()) {
            Direccion _direccion = direccionData.get();
            _direccion.setDireccion(direccion.getDireccion());
            _direccion.setPersonal(direccion.getPersonal());
            direccionRepository.save(_direccion);
            return new ResponseEntity<>(_direccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/direccion/delete")
    public ResponseEntity<HttpStatus> deleteDireccion(@RequestParam Long id) {
        try {
            direccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 5------------------ TIPODOCUMENTO -----------------------
    @PostMapping("/tipodocumento/create")
    public ResponseEntity<TipoDocumento> createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        try {
            TipoDocumento _tipoDocumento = tipoDocumentoRepository.save(tipoDocumento);
            return new ResponseEntity<>(_tipoDocumento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tipodocumento/read")
    public ResponseEntity<TipoDocumento> readTipoDocumento(@RequestParam Long id) {
        Optional<TipoDocumento> tipoDocumentoData = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoData.isPresent()) {
            return new ResponseEntity<>(tipoDocumentoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tipodocumento/update")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        Optional<TipoDocumento> tipoDocumentoData = tipoDocumentoRepository.findById(tipoDocumento.getIdtipodocumento());
        if (tipoDocumentoData.isPresent()) {
            TipoDocumento _tipoDocumento = tipoDocumentoData.get();
            _tipoDocumento.setIdtipodocumento(tipoDocumento.getIdtipodocumento());
            tipoDocumentoRepository.save(_tipoDocumento);
            return new ResponseEntity<>(_tipoDocumento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tipodocumento/delete")
    public ResponseEntity<HttpStatus> deleteTipoDocumento(@RequestParam Long id) {
        try {
            tipoDocumentoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 6------------------ ROL -----------------------
    @PostMapping("/rol/create")
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        try {
            Rol _rol = rolRepository.save(rol);
            return new ResponseEntity<>(_rol, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rol/read")
    public ResponseEntity<Rol> readRol(@RequestParam Long id) {
        Optional<Rol> rolData = rolRepository.findById(id);
        if (rolData.isPresent()) {
            return new ResponseEntity<>(rolData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/rol/update")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol) {
        Optional<Rol> rolData = rolRepository.findById(rol.getIdrol());
        if (rolData.isPresent()) {
            Rol _rol = rolData.get();
            _rol.setIdrol(rol.getIdrol());
            _rol.setDescripcion(rol.getDescripcion());
            _rol.setEstado(rol.getEstado());
            rolRepository.save(_rol);
            return new ResponseEntity<>(_rol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/rol/delete")
    public ResponseEntity<HttpStatus> deleteRol(@RequestParam Long id) {
        try {
            rolRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 7------------------ PERMISOS -----------------------
    @PostMapping("/permisos/create")
    public ResponseEntity<Permisos> createPermisos(@RequestBody Permisos permisos) {
        try {
            Permisos _permisos = permisosRepository.save(permisos);
            return new ResponseEntity<>(_permisos, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/permisos/read")
    public ResponseEntity<Permisos> readPermisos(@RequestParam Long id) {
        Optional<Permisos> permisosData = permisosRepository.findById(id);
        if (permisosData.isPresent()) {
            return new ResponseEntity<>(permisosData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/permisos/update")
    public ResponseEntity<Permisos> updatePermisos(@RequestBody Permisos permisos) {
        Optional<Permisos> permisosData = permisosRepository.findById(permisos.getIdpermiso());
        if (permisosData.isPresent()) {
            Permisos _permisos = permisosData.get();
            _permisos.setIdrol(permisos.getIdrol());
            _permisos.setIdmodulo(permisos.getIdmodulo());
            _permisos.setEstado(permisos.getEstado());

            permisosRepository.save(_permisos);
            return new ResponseEntity<>(_permisos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/permisos/delete")
    public ResponseEntity<HttpStatus> deletePermisos(@RequestParam Long id) {
        try {
            permisosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 8------------------ MODULO -----------------------
    @PostMapping("/modulo/create")
    public ResponseEntity<Modulo> createModulo(@RequestBody Modulo modulo) {
        try {
            Modulo _modulo = moduloRepository.save(modulo);
            return new ResponseEntity<>(_modulo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/modulo/read")
    public ResponseEntity<Modulo> readModulo(@RequestParam Long id) {
        Optional<Modulo> moduloData = moduloRepository.findById(id);
        if (moduloData.isPresent()) {
            return new ResponseEntity<>(moduloData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/modulo/update")
    public ResponseEntity<Modulo> updateModulo(@RequestBody Modulo modulo) {
        Optional<Modulo> moduloData = moduloRepository.findById(modulo.getIdmodulo());
        if (moduloData.isPresent()) {
            Modulo _modulo = moduloData.get();
            _modulo.setTitulo(modulo.getTitulo());
            _modulo.setDescripcion(modulo.getDescripcion());
            _modulo.setEstado(modulo.getEstado());
            moduloRepository.save(_modulo);
            return new ResponseEntity<>(_modulo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/modulo/delete")
    public ResponseEntity<HttpStatus> deleteModulo(@RequestParam Long id) {
        try {
            moduloRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 9------------------ PRODUCTO -----------------------
    @PostMapping("/producto/create")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        try {
            Producto _producto = productoRepository.save(producto);
            return new ResponseEntity<>(_producto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/producto/read")
    public ResponseEntity<Producto> readProducto(@RequestParam Long id) {
        Optional<Producto> productoData = productoRepository.findById(id);
        if (productoData.isPresent()) {
            return new ResponseEntity<>(productoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/producto/update")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        Optional<Producto> productoData = productoRepository.findById(producto.getIdproducto());
        if (productoData.isPresent()) {
            Producto _producto = productoData.get();
            _producto.setCategoriaId(producto.getCategoriaId());
            _producto.setCodigo(producto.getCodigo());
            _producto.setNombre(producto.getNombre());
            _producto.setDescripcion(producto.getDescripcion());
            _producto.setPrecio(producto.getPrecio());
            _producto.setStock(producto.getStock());
            _producto.setImagen(producto.getImagen());
            _producto.setDateCreated(producto.getDateCreated());
            _producto.setRuta(producto.getRuta());
            _producto.setStatus(producto.getStatus());
            productoRepository.save(_producto);
            return new ResponseEntity<>(_producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/producto/delete")
    public ResponseEntity<HttpStatus> deleteProducto(@RequestParam Long id) {
        try {
            productoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 10------------------ CATEGORIA -----------------------
    @PostMapping("/categoria/create")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        try {
            Categoria _categoria = categoriaRepository.save(categoria);
            return new ResponseEntity<>(_categoria, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/categoria/read")
    public ResponseEntity<Categoria> readCategoria(@RequestParam Long id) {
        Optional<Categoria> categoriaData = categoriaRepository.findById(id);
        if (categoriaData.isPresent()) {
            return new ResponseEntity<>(categoriaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categoria/update")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
        Optional<Categoria> categoriaData = categoriaRepository.findById(categoria.getIdcategoria());
        if (categoriaData.isPresent()) {
            Categoria _categoria = categoriaData.get();
            _categoria.setNombre(categoria.getNombre());
            _categoria.setDescripcion(categoria.getDescripcion());
            _categoria.setRuta(categoria.getRuta());
            _categoria.setDateCreated(categoria.getDateCreated());
            _categoria.setStatus(categoria.getStatus());
            categoriaRepository.save(_categoria);
            return new ResponseEntity<>(_categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categoria/delete")
    public ResponseEntity<HttpStatus> deleteCategoria(@RequestParam Long id) {
        try {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 11------------------ IMAGEN -----------------------
    @PostMapping("/imagen/create")
    public ResponseEntity<Imagen> createImagen(@RequestBody Imagen imagen) {
        try {
            Imagen _imagen = imagenRepository.save(imagen);
            return new ResponseEntity<>(_imagen, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/imagen/read")
    public ResponseEntity<Imagen> readImagen(@RequestParam Long id) {
        Optional<Imagen> imagenData = imagenRepository.findById(id);
        if (imagenData.isPresent()) {
            return new ResponseEntity<>(imagenData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/imagen/update")
    public ResponseEntity<Imagen> updateImagen(@RequestBody Imagen imagen) {
        Optional<Imagen> imagenData = imagenRepository.findById(imagen.getId());
        if (imagenData.isPresent()) {
            Imagen _imagen = imagenData.get();
            _imagen.setProductoId(imagen.getProductoId());
            _imagen.setImg(imagen.getImg());
            imagenRepository.save(_imagen);
            return new ResponseEntity<>(_imagen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/imagen/delete")
    public ResponseEntity<HttpStatus> deleteImagen(@RequestParam Long id) {
        try {
            imagenRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 12------------------ DETALLEPEDIDO -----------------------
    @PostMapping("/detallepedido/create")
    public ResponseEntity<DetallePedido> createDetallePedido(@RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido _detallePedido = detallePedidoRepository.save(detallePedido);
            return new ResponseEntity<>(_detallePedido, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/detallepedido/read")
    public ResponseEntity<DetallePedido> readDetallePedido(@RequestParam Long id) {
        Optional<DetallePedido> detallePedidoData = detallePedidoRepository.findById(id);
        if (detallePedidoData.isPresent()) {
            return new ResponseEntity<>(detallePedidoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/detallepedido/update")
    public ResponseEntity<DetallePedido> updateDetallePedido(@RequestBody DetallePedido detallePedido) {
        Optional<DetallePedido> detallePedidoData = detallePedidoRepository.findById(detallePedido.getId());
        if (detallePedidoData.isPresent()) {
            DetallePedido _detallePedido = detallePedidoData.get();
            _detallePedido.setPedidoId(detallePedido.getPedidoId());
            _detallePedido.setProductoId(detallePedido.getProductoId());
            _detallePedido.setPrecio(detallePedido.getPrecio());
            _detallePedido.setCantidad(detallePedido.getCantidad());
            _detallePedido.setSubtotal(detallePedido.getSubtotal());
            detallePedidoRepository.save(_detallePedido);
            return new ResponseEntity<>(_detallePedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/detallepedido/delete")
    public ResponseEntity<HttpStatus> deleteDetallePedido(@RequestParam Long id) {
        try {
            detallePedidoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 13------------------ DETALLETEMP -----------------------
    @PostMapping("/detalletemp/create")
    public ResponseEntity<DetalleTemp> createDetalleTemp(@RequestBody DetalleTemp detalleTemp) {
        try {
            DetalleTemp _detalleTemp = detalleTempRepository.save(detalleTemp);
            return new ResponseEntity<>(_detalleTemp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/detalletemp/read")
    public ResponseEntity<DetalleTemp> readDetalleTemp(@RequestParam Long id) {
        Optional<DetalleTemp> detalleTempData = detalleTempRepository.findById(id);
        if (detalleTempData.isPresent()) {
            return new ResponseEntity<>(detalleTempData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/detalletemp/update")
    public ResponseEntity<DetalleTemp> updateDetalleTemp(@RequestBody DetalleTemp detalleTemp) {
        Optional<DetalleTemp> detalleTempData = detalleTempRepository.findById(detalleTemp.getId());
        if (detalleTempData.isPresent()) {
            DetalleTemp _detalleTemp = detalleTempData.get();
            _detalleTemp.setPersonal(detalleTemp.getPersonal());
            _detalleTemp.setProductoId(detalleTemp.getProductoId());
            _detalleTemp.setPrecio(detalleTemp.getPrecio());
            _detalleTemp.setCantidad(detalleTemp.getCantidad());
            _detalleTemp.setTransaccionId(detalleTemp.getTransaccionId());
            detalleTempRepository.save(_detalleTemp);
            return new ResponseEntity<>(_detalleTemp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/detalletemp/delete")
    public ResponseEntity<HttpStatus> deleteDetalleTemp(@RequestParam Long id) {
        try {
            detalleTempRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 14------------------ PEDIDO -----------------------
    @PostMapping("/pedido/create")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        try {
            Pedido _pedido = pedidoRepository.save(pedido);
            return new ResponseEntity<>(_pedido, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pedido/read")
    public ResponseEntity<Pedido> readPedido(@RequestParam Long id) {
        Optional<Pedido> pedidoData = pedidoRepository.findById(id);
        if (pedidoData.isPresent()) {
            return new ResponseEntity<>(pedidoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/pedido/update")
    public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido) {
        Optional<Pedido> pedidoData = pedidoRepository.findById(pedido.getIdpedido());
        if (pedidoData.isPresent()) {
            Pedido _pedido = pedidoData.get();
            _pedido.setReferenciaCobro(pedido.getReferenciaCobro());
            _pedido.setIdTransaccionPaypal(pedido.getIdTransaccionPaypal());
            _pedido.setDatosPaypal(pedido.getDatosPaypal());
            _pedido.setPersonal(pedido.getPersonal());
            _pedido.setFecha(pedido.getFecha());
            _pedido.setCostoEnvio(pedido.getCostoEnvio());
            _pedido.setMonto(pedido.getMonto());
            _pedido.setTipoPagoId(pedido.getTipoPagoId());
            _pedido.setDireccionEnvio(pedido.getDireccionEnvio());
            _pedido.setStatus(pedido.getStatus());
            pedidoRepository.save(_pedido);
            return new ResponseEntity<>(_pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/pedido/delete")
    public ResponseEntity<HttpStatus> deletePedido(@RequestParam Long id) {
        try {
            pedidoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 15------------------ TIPOPAGO -----------------------
    @PostMapping("/tipopago/create")
    public ResponseEntity<TipoPago> createTipoPago(@RequestBody TipoPago tipoPago) {
        try {
            TipoPago _tipoPago = tipoPagoRepository.save(tipoPago);
            return new ResponseEntity<>(_tipoPago, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/tipopago/read")
    public ResponseEntity<TipoPago> readTipoPago(@RequestParam Long id) {
        Optional<TipoPago> tipoPagoData = tipoPagoRepository.findById(id);
        if (tipoPagoData.isPresent()) {
            return new ResponseEntity<>(tipoPagoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tipopago/update")
    public ResponseEntity<TipoPago> updateTipoPago(@RequestBody TipoPago tipoPago) {
        Optional<TipoPago> tipoPagoData = tipoPagoRepository.findById(tipoPago.getIdtipopago());
        if (tipoPagoData.isPresent()) {
            TipoPago _tipoPago = tipoPagoData.get();
            _tipoPago.setTipoPago(tipoPago.getTipoPago());
            _tipoPago.setStatus(tipoPago.getStatus());
            tipoPagoRepository.save(_tipoPago);
            return new ResponseEntity<>(_tipoPago, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tipopago/delete")
    public ResponseEntity<HttpStatus> deleteTipoPago(@RequestParam Long id) {
        try {
            tipoPagoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 16------------------ REEMBOLSO -----------------------
    @PostMapping("/reembolso/create")
    public ResponseEntity<Reembolso> createReembolso(@RequestBody Reembolso reembolso) {
        try {
            Reembolso _reembolso = reembolsoRepository.save(reembolso);
            return new ResponseEntity<>(_reembolso, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reembolso/read")
    public ResponseEntity<Reembolso> readReembolso(@RequestParam Long id) {
        Optional<Reembolso> reembolsoData = reembolsoRepository.findById(id);
        if (reembolsoData.isPresent()) {
            return new ResponseEntity<>(reembolsoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reembolso/update")
    public ResponseEntity<Reembolso> updateReembolso(@RequestBody Reembolso reembolso) {
        Optional<Reembolso> reembolsoData = reembolsoRepository.findById(reembolso.getId());
        if (reembolsoData.isPresent()) {
            Reembolso _reembolso = reembolsoData.get();
            _reembolso.setPedidoId(reembolso.getPedidoId());
            _reembolso.setIdTransaccion(reembolso.getIdTransaccion());
            _reembolso.setDatosReembolso(reembolso.getDatosReembolso());
            _reembolso.setObservacion(reembolso.getObservacion());
            _reembolso.setStatus(reembolso.getStatus());
            reembolsoRepository.save(_reembolso);
            return new ResponseEntity<>(_reembolso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reembolso/delete")
    public ResponseEntity<HttpStatus> deleteReembolso(@RequestParam Long id) {
        try {
            reembolsoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 17------------------ SUSCRIPCIONES -----------------------
    @PostMapping("/suscripciones/create")
    public ResponseEntity<Suscripciones> createSuscripciones(@RequestBody Suscripciones suscripciones) {
        try {
            Suscripciones _suscripciones = suscripcionesRepository.save(suscripciones);
            return new ResponseEntity<>(_suscripciones, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/suscripciones/read")
    public ResponseEntity<Suscripciones> readSuscripciones(@RequestParam Long id) {
        Optional<Suscripciones> suscripcionesData = suscripcionesRepository.findById(id);
        if (suscripcionesData.isPresent()) {
            return new ResponseEntity<>(suscripcionesData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/suscripciones/update")
    public ResponseEntity<Suscripciones> updateSuscripciones(@RequestBody Suscripciones suscripciones) {
        Optional<Suscripciones> suscripcionesData = suscripcionesRepository.findById(suscripciones.getIdsuscripcion());
        if (suscripcionesData.isPresent()) {
            Suscripciones _suscripciones = suscripcionesData.get();
            _suscripciones.setEmail(suscripciones.getEmail());
            _suscripciones.setDatecreated(suscripciones.getDatecreated());
            _suscripciones.setStatus(suscripciones.getStatus());
            suscripcionesRepository.save(_suscripciones);
            return new ResponseEntity<>(_suscripciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/suscripciones/delete")
    public ResponseEntity<HttpStatus> deleteSuscripciones(@RequestParam Long id) {
        try {
            suscripcionesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 18------------------ CONTACTO -----------------------
    @PostMapping("/contacto/create")
    public ResponseEntity<Contacto> createContacto(@RequestBody Contacto contacto) {
        try {
            Contacto _contacto = contactoRepository.save(contacto);
            return new ResponseEntity<>(_contacto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contacto/read")
    public ResponseEntity<Contacto> readContacto(@RequestParam Long id) {
        Optional<Contacto> contactoData = contactoRepository.findById(id);
        if (contactoData.isPresent()) {
            return new ResponseEntity<>(contactoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/contacto/update")
    public ResponseEntity<Contacto> updateContacto(@RequestBody Contacto contacto) {
        Optional<Contacto> contactoData = contactoRepository.findById(contacto.getIdcontacto());
        if (contactoData.isPresent()) {
            Contacto _contacto = contactoData.get();
            _contacto.setNombre(contacto.getNombre());
            _contacto.setCorreo(contacto.getCorreo());
            _contacto.setMensaje(contacto.getMensaje());
            _contacto.setFecha(contacto.getFecha());
            _contacto.setEstado(contacto.getEstado());
            contactoRepository.save(_contacto);
            return new ResponseEntity<>(_contacto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/contacto/delete")
    public ResponseEntity<HttpStatus> deleteContacto(@RequestParam Long id) {
        try {
            contactoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 19------------------ POST -----------------------
    @PostMapping("/post/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            Post _post = postRepository.save(post);
            return new ResponseEntity<>(_post, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/post/read")
    public ResponseEntity<Post> readPost(@RequestParam Long id) {
        Optional<Post> postData = postRepository.findById(id);
        if (postData.isPresent()) {
            return new ResponseEntity<>(postData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        Optional<Post> postData = postRepository.findById(post.getIdpost());
        if (postData.isPresent()) {
            Post _post = postData.get();
            _post.setTitulo(post.getTitulo());
            _post.setDescripcion(post.getDescripcion());
            _post.setFecha(post.getFecha());
            _post.setEstado(post.getEstado());
            postRepository.save(_post);
            return new ResponseEntity<>(_post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post/delete")
    public ResponseEntity<HttpStatus> deletePost(@RequestParam Long id) {
        try {
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        // ------------------ USUARIO -----------------------
    @PostMapping("/usuario/list")
    public ResponseEntity<List<Usuario>> listUsuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ BITACORA -----------------------
    @PostMapping("/bitacora/list")
    public ResponseEntity<List<Bitacora>> listBitacoras() {
        return new ResponseEntity<>(bitacoraRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ PERSONA -----------------------
    @PostMapping("/persona/list")
    public ResponseEntity<List<Persona>> listPersonas() {
        return new ResponseEntity<>(personaRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ DIRECCION -----------------------
    @PostMapping("/direccion/list")
    public ResponseEntity<List<Direccion>> listDirecciones() {
        return new ResponseEntity<>(direccionRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ TIPODOCUMENTO -----------------------
    @PostMapping("/tipodocumento/list")
    public ResponseEntity<List<TipoDocumento>> listTipoDocumentos() {
        return new ResponseEntity<>(tipoDocumentoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ ROL -----------------------
    @PostMapping("/rol/list")
    public ResponseEntity<List<Rol>> listRoles() {
        return new ResponseEntity<>(rolRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ PERMISOS -----------------------
    @PostMapping("/permisos/list")
    public ResponseEntity<List<Permisos>> listPermisos() {
        return new ResponseEntity<>(permisosRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ MODULO -----------------------
    @PostMapping("/modulo/list")
    public ResponseEntity<List<Modulo>> listModulos() {
        return new ResponseEntity<>(moduloRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ PRODUCTO -----------------------
    @PostMapping("/producto/list")
    public ResponseEntity<List<Producto>> listProductos() {
        return new ResponseEntity<>(productoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ CATEGORIA -----------------------
    @PostMapping("/categoria/list")
    public ResponseEntity<List<Categoria>> listCategorias() {
        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ IMAGEN -----------------------
    @PostMapping("/imagen/list")
    public ResponseEntity<List<Imagen>> listImagenes() {
        return new ResponseEntity<>(imagenRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ DETALLEPEDIDO -----------------------
    @PostMapping("/detallepedido/list")
    public ResponseEntity<List<DetallePedido>> listDetallePedidos() {
        return new ResponseEntity<>(detallePedidoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ DETALLETEMP -----------------------
    @PostMapping("/detalletemp/list")
    public ResponseEntity<List<DetalleTemp>> listDetalleTemps() {
        return new ResponseEntity<>(detalleTempRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ PEDIDO -----------------------
    @PostMapping("/pedido/list")
    public ResponseEntity<List<Pedido>> listPedidos() {
        return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ TIPOPAGO -----------------------
    @PostMapping("/tipopago/list")
    public ResponseEntity<List<TipoPago>> listTipoPagos() {
        return new ResponseEntity<>(tipoPagoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ REEMBOLSO -----------------------
    @PostMapping("/reembolso/list")
    public ResponseEntity<List<Reembolso>> listReembolsos() {
        return new ResponseEntity<>(reembolsoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ SUSCRIPCIONES -----------------------
    @PostMapping("/suscripciones/list")
    public ResponseEntity<List<Suscripciones>> listSuscripciones() {
        return new ResponseEntity<>(suscripcionesRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ CONTACTO -----------------------
    @PostMapping("/contacto/list")
    public ResponseEntity<List<Contacto>> listContactos() {
        return new ResponseEntity<>(contactoRepository.findAll(), HttpStatus.OK);
    }

    // ------------------ POST -----------------------
    @PostMapping("/post/list")
    public ResponseEntity<List<Post>> listPosts() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    
}
