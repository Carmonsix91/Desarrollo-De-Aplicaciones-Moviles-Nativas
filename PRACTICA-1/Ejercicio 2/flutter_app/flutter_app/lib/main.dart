import 'package:flutter/material.dart';

void main() {
  runApp(const UIElementsDemoApp());
}

class UIElementsDemoApp extends StatelessWidget {
  const UIElementsDemoApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'UI Elements Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.pink),
        useMaterial3: true,
      ),
      home: const MainScreen(),
    );
  }
}

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _selectedIndex = 0;

  static final List<Widget> _screens = [
    const TextFieldsScreen(),
    const ButtonsScreen(),
    const SelectionScreen(),
    const ListsScreen(),
    const InformationScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('UI Elements Demo'),
        backgroundColor: Colors.pink[200],
        foregroundColor: Colors.white,
      ),
      body: _screens[_selectedIndex],
      bottomNavigationBar: Container(
        decoration: BoxDecoration(
          color: Colors.pink[100],
          boxShadow: [
            BoxShadow(
              color: Colors.grey.withOpacity(0.5),
              spreadRadius: 1,
              blurRadius: 5,
              offset: const Offset(0, -2),
            ),
          ],
        ),
        child: BottomNavigationBar(
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.text_fields),
              label: 'TextFields',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.smart_button),
              label: 'Buttons',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.check_box),
              label: 'Selection',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.list),
              label: 'Lists',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.info),
              label: 'Information',
            ),
          ],
          currentIndex: _selectedIndex,
          selectedItemColor: Colors.pink[800],
          unselectedItemColor: Colors.pink[400],
          backgroundColor: Colors.transparent,
          elevation: 0,
          onTap: _onItemTapped,
          type: BottomNavigationBarType.fixed,
        ),
      ),
    );
  }
}

// Screen 1: TextFields
class TextFieldsScreen extends StatefulWidget {
  const TextFieldsScreen({super.key});

  @override
  State<TextFieldsScreen> createState() => _TextFieldsScreenState();
}

class _TextFieldsScreenState extends State<TextFieldsScreen> {
  final TextEditingController _textController = TextEditingController();
  final TextEditingController _numberController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  @override
  void dispose() {
    _textController.dispose();
    _numberController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'TextFields',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          const Text(
            'Los campos de texto permiten a los usuarios ingresar y editar información. Son esenciales para formularios, búsquedas y cualquier entrada de datos.',
            style: TextStyle(fontSize: 16),
          ),
          const SizedBox(height: 24),
          TextField(
            controller: _textController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'TextField estándar',
              hintText: 'Escribe algo aquí',
            ),
            onChanged: (value) {
              setState(() {});
            },
          ),
          const SizedBox(height: 16),
          TextField(
            controller: _numberController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Campo numérico',
              hintText: 'Ingresa un número',
            ),
            keyboardType: TextInputType.number,
          ),
          const SizedBox(height: 16),
          TextField(
            controller: _passwordController,
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Contraseña',
              hintText: 'Ingresa tu contraseña',
            ),
            obscureText: true,
          ),
          const SizedBox(height: 24),
          const Text(
            'Texto ingresado:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Text(_textController.text.isNotEmpty ? _textController.text : 'Nada escrito aún'),
        ],
      ),
    );
  }
}

// Screen 2: Buttons
class ButtonsScreen extends StatefulWidget {
  const ButtonsScreen({super.key});

  @override
  State<ButtonsScreen> createState() => _ButtonsScreenState();
}

class _ButtonsScreenState extends State<ButtonsScreen> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  void _decrementCounter() {
    setState(() {
      if (_counter > 0) _counter--;
    });
  }

  void _resetCounter() {
    setState(() {
      _counter = 0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Botones',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          const Text(
            'Los botones permiten a los usuarios realizar acciones con un simple toque. Hay diferentes estilos para diferentes propósitos y contextos.',
            style: TextStyle(fontSize: 16),
          ),
          const SizedBox(height: 24),
          ElevatedButton(
            onPressed: _incrementCounter,
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.pink[200],
              foregroundColor: Colors.white,
            ),
            child: const Text('Elevated Button'),
          ),
          const SizedBox(height: 16),
          OutlinedButton(
            onPressed: _decrementCounter,
            style: OutlinedButton.styleFrom(
              foregroundColor: Colors.pink[400],
              side: BorderSide(color: Colors.pink[400]!),
            ),
            child: const Text('Outlined Button'),
          ),
          const SizedBox(height: 16),
          TextButton(
            onPressed: _resetCounter,
            style: TextButton.styleFrom(
              foregroundColor: Colors.pink[400],
            ),
            child: const Text('Text Button'),
          ),
          const SizedBox(height: 16),
          IconButton(
            onPressed: _incrementCounter,
            icon: const Icon(Icons.favorite),
            style: IconButton.styleFrom(
              backgroundColor: Colors.pink[400],
              foregroundColor: Colors.white,
            ),
          ),
          const SizedBox(height: 16),
          FloatingActionButton(
            onPressed: _incrementCounter,
            backgroundColor: Colors.pink[400],
            child: const Icon(Icons.add, color: Colors.white),
          ),
          const SizedBox(height: 24),
          const Divider(),
          const SizedBox(height: 16),
          const Text(
            'Contador de acciones:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Text('$_counter', style: const TextStyle(fontSize: 24)),
          const SizedBox(height: 16),
          ElevatedButton(
            onPressed: _counter > 0 ? _decrementCounter : null,
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.pink[200],
              foregroundColor: Colors.white,
            ),
            child: const Text('Decrementar (solo si > 0)'),
          ),
        ],
      ),
    );
  }
}

// Screen 3: Selection Elements
class SelectionScreen extends StatefulWidget {
  const SelectionScreen({super.key});

  @override
  State<SelectionScreen> createState() => _SelectionScreenState();
}

class _SelectionScreenState extends State<SelectionScreen> {
  bool _checkbox1 = false;
  bool _checkbox2 = false;
  bool _checkbox3 = false;

  int _radioValue = 0;

  bool _switch1 = false;
  bool _switch2 = false;

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Elementos de Selección',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          const Text(
            'Estos elementos permiten a los usuarios seleccionar entre diferentes opciones. Los checkboxes permiten selección múltiple, los radio buttons selección única y los switches activar/desactivar funciones.',
            style: TextStyle(fontSize: 16),
          ),
          const SizedBox(height: 24),
          const Text(
            'Checkboxes (selección múltiple):',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          Row(
            children: [
              Checkbox(
                value: _checkbox1,
                activeColor: Colors.pink[400],
                onChanged: (bool? value) {
                  setState(() {
                    _checkbox1 = value!;
                  });
                },
              ),
              const Text('Opción 1'),
            ],
          ),
          Row(
            children: [
              Checkbox(
                value: _checkbox2,
                activeColor: Colors.pink[400],
                onChanged: (bool? value) {
                  setState(() {
                    _checkbox2 = value!;
                  });
                },
              ),
              const Text('Opción 2'),
            ],
          ),
          Row(
            children: [
              Checkbox(
                value: _checkbox3,
                activeColor: Colors.pink[400],
                onChanged: (bool? value) {
                  setState(() {
                    _checkbox3 = value!;
                  });
                },
              ),
              const Text('Opción 3'),
            ],
          ),
          const SizedBox(height: 24),
          const Text(
            'Radio Buttons (selección única):',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          Row(
            children: [
              Radio<int>(
                value: 0,
                groupValue: _radioValue,
                activeColor: Colors.pink[400],
                onChanged: (int? value) {
                  setState(() {
                    _radioValue = value!;
                  });
                },
              ),
              const Text('Opción A'),
            ],
          ),
          Row(
            children: [
              Radio<int>(
                value: 1,
                groupValue: _radioValue,
                activeColor: Colors.pink[400],
                onChanged: (int? value) {
                  setState(() {
                    _radioValue = value!;
                  });
                },
              ),
              const Text('Opción B'),
            ],
          ),
          Row(
            children: [
              Radio<int>(
                value: 2,
                groupValue: _radioValue,
                activeColor: Colors.pink[400],
                onChanged: (int? value) {
                  setState(() {
                    _radioValue = value!;
                  });
                },
              ),
              const Text('Opción C'),
            ],
          ),
          const SizedBox(height: 24),
          const Text(
            'Switches:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              const Text('Modo oscuro'),
              Switch(
                value: _switch1,
                activeColor: Colors.pink[400],
                onChanged: (bool value) {
                  setState(() {
                    _switch1 = value;
                  });
                },
              ),
            ],
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              const Text('Notificaciones'),
              Switch(
                value: _switch2,
                activeColor: Colors.pink[400],
                onChanged: (bool value) {
                  setState(() {
                    _switch2 = value;
                  });
                },
              ),
            ],
          ),
          const SizedBox(height: 24),
          const Divider(),
          const SizedBox(height: 16),
          const Text(
            'Estado actual:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Text('Checkboxes: ${_checkbox1 ? "1" : ""} ${_checkbox2 ? "2" : ""} ${_checkbox3 ? "3" : ""}'),
          Text('Radio seleccionado: ${_radioValue == 0 ? "A" : _radioValue == 1 ? "B" : "C"}'),
          Text('Modo oscuro: ${_switch1 ? "Activado" : "Desactivado"}'),
          Text('Notificaciones: ${_switch2 ? "Activadas" : "Desactivadas"}'),
        ],
      ),
    );
  }
}

// Screen 4: Lists
class ListsScreen extends StatefulWidget {
  const ListsScreen({super.key});

  @override
  State<ListsScreen> createState() => _ListsScreenState();
}

class _ListsScreenState extends State<ListsScreen> {
  final List<String> _items = List.generate(20, (index) => 'Elemento ${index + 1}');

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        const Padding(
          padding: EdgeInsets.all(16.0),
          child: Text(
            'Listas',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
        ),
        const Padding(
          padding: EdgeInsets.symmetric(horizontal: 16.0),
          child: Text(
            'Las listas muestran colecciones de datos de manera eficiente, renderizando solo los elementos visibles. Son fundamentales para mostrar grandes cantidades de información organizada.',
            style: TextStyle(fontSize: 16),
          ),
        ),
        const SizedBox(height: 16),
        Expanded(
          child: ListView.builder(
            itemCount: _items.length,
            itemBuilder: (context, index) {
              return ListTile(
                leading: Icon(Icons.star_border, color: Colors.pink[400]),
                title: Text(_items[index]),
                subtitle: Text('Subtítulo del ${_items[index]}'),
                trailing: IconButton(
                  icon: Icon(Icons.delete_outline, color: Colors.pink[400]),
                  onPressed: () {
                    setState(() {
                      _items.removeAt(index);
                    });
                  },
                ),
                onTap: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text('Tocaste: ${_items[index]}'),
                      backgroundColor: Colors.pink[200],
                    )
                  );
                },
              );
            },
          ),
        ),
      ],
    );
  }
}

// Screen 5: Information Elements
class InformationScreen extends StatefulWidget {
  const InformationScreen({super.key});

  @override
  State<InformationScreen> createState() => _InformationScreenState();
}

class _InformationScreenState extends State<InformationScreen> {
  double _progressValue = 0.5;

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Elementos de Información',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          const Text(
            'Estos elementos muestran información al usuario sin requerir interacción directa. Incluyen textos, imágenes, indicadores de progreso y más.',
            style: TextStyle(fontSize: 16),
          ),
          const SizedBox(height: 24),
          const Text(
            'Textos:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          const Text('Este es un texto normal'),
          const SizedBox(height: 8),
          Text(
            'Texto con estilo',
            style: TextStyle(
              fontSize: 18,
              fontWeight: FontWeight.bold,
              color: Colors.pink[600],
            ),
          ),
          const SizedBox(height: 8),
          const Text.rich(
            TextSpan(
              text: 'Texto ',
              children: <TextSpan>[
                TextSpan(
                  text: 'enriquecido',
                  style: TextStyle(fontWeight: FontWeight.bold),
                ),
                TextSpan(text: ' con '),
                TextSpan(
                  text: 'diferentes',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
                TextSpan(text: ' estilos'),
              ],
            ),
          ),
          const SizedBox(height: 24),
          const Text(
            'Imágenes:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Image.network(
            'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl-2.jpg',
            height: 150,
            fit: BoxFit.cover,
            errorBuilder: (context, error, stackTrace) => const Icon(Icons.error),
          ),
          const SizedBox(height: 8),
          const Text(
            'Imagen de ejemplo de Flutter',
            style: TextStyle(fontSize: 12, fontStyle: FontStyle.italic),
          ),
          const SizedBox(height: 24),
          const Text(
            'Indicadores de Progreso:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          LinearProgressIndicator(
            value: _progressValue,
            backgroundColor: Colors.pink[100],
            valueColor: AlwaysStoppedAnimation<Color>(Colors.pink[400]!),
          ),
          const SizedBox(height: 8),
          CircularProgressIndicator(
            value: _progressValue,
            backgroundColor: Colors.pink[100],
            valueColor: AlwaysStoppedAnimation<Color>(Colors.pink[400]!),
          ),
          const SizedBox(height: 16),
          Slider(
            value: _progressValue,
            min: 0,
            max: 1,
            activeColor: Colors.pink[400],
            inactiveColor: Colors.pink[100],
            onChanged: (double value) {
              setState(() {
                _progressValue = value;
              });
            },
          ),
          const SizedBox(height: 8),
          Text('Valor: ${(_progressValue * 100).toStringAsFixed(0)}%'),
          const SizedBox(height: 24),
          const Text(
            'Iconos:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 8),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Icon(Icons.favorite, color: Colors.pink[400]),
              Icon(Icons.thumb_up, color: Colors.pink[400]),
              Icon(Icons.star, color: Colors.pink[400]),
              Icon(Icons.lightbulb, color: Colors.pink[400]),
              Icon(Icons.phone, color: Colors.pink[400]),
            ],
          ),
        ],
      ),
    );
  }
}