from kivymd.app import MDApp
from kivymd.uix.screen import MDScreen
from kivymd.uix.button import MDRaisedButton
from kivymd.uix.textfield import MDTextField
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.scrollview import ScrollView

class HTMLConverterApp(MDApp):
    def build(self):
        self.theme_cls.primary_palette = "Blue"
        screen = MDScreen()
        
        scroll = ScrollView()
        inner_layout = BoxLayout(orientation='vertical', padding=20, spacing=15, size_hint_y=None)
        inner_layout.bind(minimum_height=inner_layout.setter('height'))

        # UI Elements
        self.html_input = MDTextField(hint_text="اپنا HTML کوڈ یہاں ڈالیں", multiline=True, mode="outline")
        self.sync_key = MDTextField(hint_text="Sync Key (Required)", mode="rectangle")
        self.fb_config = MDTextField(hint_text="Advanced Config (Firebase JSON)", password=True, mode="rectangle")
        
        btn_layout = BoxLayout(size_hint_y=None, height="50dp", spacing=10)
        build_btn = MDRaisedButton(text="Build APK", on_release=self.on_click)
        update_btn = MDRaisedButton(text="All Data (Update)", on_release=self.on_click)
        
        btn_layout.add_widget(build_btn)
        btn_layout.add_widget(update_btn)
        
        inner_layout.add_widget(self.html_input)
        inner_layout.add_widget(self.sync_key)
        inner_layout.add_widget(self.fb_config)
        inner_layout.add_widget(btn_layout)
        
        scroll.add_widget(inner_layout)
        screen.add_widget(scroll)
        return screen

    def on_click(self, instance):
        print("Manual action triggered.")

if __name__ == "__main__":
    HTMLConverterApp().run()
