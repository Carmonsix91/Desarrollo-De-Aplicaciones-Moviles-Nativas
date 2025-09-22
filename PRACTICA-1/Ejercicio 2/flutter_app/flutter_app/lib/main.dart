import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Navigation Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const HomeScreen(),
    );
  }
}

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  int _currentIndex = 0;
  final List<Widget> _screens = [
    const TextFieldsScreen(),
    const ButtonsScreen(),
    SelectionScreen(
      onButtonClick: (context) {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => const SecondScreen()),
        );
      },
    ),
    const ListsScreen(),
    const InformationScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFFD96AC7),
        title: const Text('Navigation'),
        leading: const Icon(Icons.text_fields), // Placeholder for your icon
      ),
      body: _screens[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        backgroundColor: const Color(0xFFD96AC7),
        currentIndex: _currentIndex,
        onTap: (index) => setState(() => _currentIndex = index),
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.text_fields),
            label: 'TextFields',
            backgroundColor: Colors.black
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.smart_button),
            label: 'Buttons',
            backgroundColor: Colors.black
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.check_box),
            label: 'Selection',
            backgroundColor: Colors.black
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.list),
            label: 'Lists',
            backgroundColor: Colors.black
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.info),
            label: 'Information',
            backgroundColor: Colors.black
          ),
        ],
      ),
    );
  }
}

class SecondScreen extends StatefulWidget {
  const SecondScreen({super.key});

  @override
  State<SecondScreen> createState() => _SecondScreenState();
}

class _SecondScreenState extends State<SecondScreen> {
  int _currentIndex = 0;
  final List<Widget> _screens = [
    const ListsScreen(),
    const InformationScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFFFF9800),
        title: const Text('Second Activity'),
        leading: const Icon(Icons.list), // Placeholder for your icon
      ),
      body: _screens[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex,
        onTap: (index) => setState(() => _currentIndex = index),
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.list),
            label: 'Lists',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.info),
            label: 'Information',
          ),
        ],
      ),
    );
  }
}

class TextFieldsScreen extends StatefulWidget {
  const TextFieldsScreen({super.key});

  @override
  State<TextFieldsScreen> createState() => _TextFieldsScreenState();
}

class _TextFieldsScreenState extends State<TextFieldsScreen> {
  String text = '';

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'TextFields',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          TextField(
            decoration: const InputDecoration(
              border: OutlineInputBorder(),
              labelText: 'Escribe algo',
            ),
            onChanged: (value) => setState(() => text = value),
          ),
          const SizedBox(height: 16),
          const Text(
            'Los TextFields permiten al usuario ingresar y editar texto. Son esenciales para formularios y entradas de datos.',
          ),
          const SizedBox(height: 8),
          Text('Texto ingresado: $text'),
        ],
      ),
    );
  }
}

class ButtonsScreen extends StatefulWidget {
  const ButtonsScreen({super.key});

  @override
  State<ButtonsScreen> createState() => _ButtonsScreenState();
}

class _ButtonsScreenState extends State<ButtonsScreen> {
  int count = 0;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Botones',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          ElevatedButton(
            onPressed: () => setState(() => count++),
            child: Text('Contador: $count'),
          ),
          const SizedBox(height: 8),
          IconButton(
            onPressed: () => setState(() => count--),
            icon: const Icon(Icons.favorite),
          ),
          const SizedBox(height: 16),
          const Text(
            'Los botones permiten realizar acciones. Button es estándar e IconButton permite usar iconos como acciones.',
          ),
        ],
      ),
    );
  }
}

class SelectionScreen extends StatefulWidget {
  final Function(BuildContext) onButtonClick;

  const SelectionScreen({super.key, required this.onButtonClick});

  @override
  State<SelectionScreen> createState() => _SelectionScreenState();
}

class _SelectionScreenState extends State<SelectionScreen> {
  bool checkboxState = false;
  String radioOption = 'Opción 1';
  bool switchState = false;
  double sliderValue = 0.5;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Elementos de Selección',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          // Checkbox
          Row(
            children: [
              Checkbox(
                value: checkboxState,
                onChanged: (value) => setState(() => checkboxState = value!),
              ),
              const SizedBox(width: 8),
              const Text('Checkbox - Selección múltiple'),
            ],
          ),
          const SizedBox(height: 16),
          // RadioButtons
          const Text('RadioButtons - Selección única:'),
          Column(
            children: [
              RadioOption(
                text: 'Opción 1',
                selected: radioOption == 'Opción 1',
                onSelect: () => setState(() => radioOption = 'Opción 1'),
              ),
              RadioOption(
                text: 'Opción 2',
                selected: radioOption == 'Opción 2',
                onSelect: () => setState(() => radioOption = 'Opción 2'),
              ),
              RadioOption(
                text: 'Opción 3',
                selected: radioOption == 'Opción 3',
                onSelect: () => setState(() => radioOption = 'Opción 3'),
              ),
            ],
          ),
          const SizedBox(height: 16),
          // Switch
          Row(
            children: [
              Switch(
                value: switchState,
                onChanged: (value) => setState(() => switchState = value),
              ),
              const SizedBox(width: 8),
              const Text('Switch - Activado/Desactivado'),
            ],
          ),
          const SizedBox(height: 24),
          // Explanation
          const Text(
            'Los elementos de selección permiten al usuario elegir entre diferentes opciones. '
            'Checkbox para selecciones múltiples, RadioButton para una única selección, '
            'y Switch para alternar entre dos estados.',
          ),
          const SizedBox(height: 16),
          // Current state
          const Text('Estado actual:'),
          Text('Checkbox: ${checkboxState ? "Seleccionado" : "No seleccionado"}'),
          Text('Opción seleccionada: $radioOption'),
          Text('Switch: ${switchState ? "Activado" : "Desactivado"}'),
          const SizedBox(height: 16),
          // Button to navigate to second activity
          ElevatedButton(
            onPressed: () => widget.onButtonClick(context),
            child: const Text('Second Activity'),
          ),
        ],
      ),
    );
  }
}

class RadioOption extends StatelessWidget {
  final String text;
  final bool selected;
  final VoidCallback onSelect;

  const RadioOption({
    super.key,
    required this.text,
    required this.selected,
    required this.onSelect,
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Radio<bool>(
          value: true,
          groupValue: selected,
          onChanged: (value) => onSelect(),
        ),
        const SizedBox(width: 8),
        Text(text),
      ],
    );
  }
}

class ListsScreen extends StatelessWidget {
  const ListsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Padding(
          padding: EdgeInsets.all(16.0),
          child: Text(
            'Listas',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
        ),
        Expanded(
          child: ListView.builder(
            itemCount: 50,
            itemBuilder: (context, index) => ListTile(
              title: Text('Elemento ${index + 1}'),
            ),
          ),
        ),
        const Padding(
          padding: EdgeInsets.all(16.0),
          child: Text(
            'LazyColumn muestra listas eficientemente renderizando solo los elementos visibles.',
          ),
        ),
      ],
    );
  }
}

class InformationScreen extends StatefulWidget {
  const InformationScreen({super.key});

  @override
  State<InformationScreen> createState() => _InformationScreenState();
}

class _InformationScreenState extends State<InformationScreen> {
  double progress = 0.5;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'Elementos de Información',
            style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),
          const Text('Este es un TextView estático'),
          const SizedBox(height: 16),
          LinearProgressIndicator(value: progress),
          const SizedBox(height: 16),
          Slider(
            value: progress,
            onChanged: (value) => setState(() => progress = value),
          ),
          const SizedBox(height: 16),
          const Icon(Icons.image, size: 128), // Placeholder for your image
          const SizedBox(height: 16),
          const Text(
            'TextView: muestra texto. ImageView: muestra imágenes. ProgressBar: indica progreso.',
          ),
        ],
      ),
    );
  }
}