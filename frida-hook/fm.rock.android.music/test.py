import frida
import sys

PACKAGE = 'fm.rock.android.music'

def on_message(message, data):
    if message['type'] == 'send':
        print("[*] {0}".format(message['payload']))
    else:
        print(message)

if __name__ == '__main__':
    jscode = open('hook.js', 'r', encoding='UTF-8').read()
    process = frida.get_usb_device().attach(PACKAGE)
    script = process.create_script(jscode)
    script.on('message', on_message)
    print('run js')
    script.load()
    sys.stdin.read()