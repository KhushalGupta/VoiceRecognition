//Imports
package voicelauncher;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
 
/**
 *
 * @author ex094
 */
public class VoiceLauncher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration();
		 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("5992.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("5992.lm");
        
        //Recognizer Object, Pass the Configuration object
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
 
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
        
      //Create SpeechResult Object
        SpeechResult result;
 
        //Checking if recognizer has recognized the speech
        while ((result = recognize.getResult()) != null) {
            //Get the recognize speech
            String command = result.getHypothesis();
            
            /* if(command.equalsIgnoreCase("open file manager")) {
                System.out.println("File Manager Opened!");
            } else if (command.equalsIgnoreCase("close file manager")) {
                System.out.println("File Manager Closed!");
            } else if (command.equalsIgnoreCase("open browser")) {
                System.out.println("Browser Opened!");
            } else if (command.equalsIgnoreCase("close browser")) {
                System.out.println("Browser Closed!");
            } */
            
            String work = null;
            Process p;
 
            if(command.equalsIgnoreCase("file manager")) {
            	work = "explorer";
            	} else if (command.equalsIgnoreCase("close file manager")) {
            	work = "Taskkill /IM explorer.exe /F";
            	} else if (command.equalsIgnoreCase("chrome")) {
            	work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
            	} else if (command.equalsIgnoreCase("close chrome")) {
            	work = "Taskkill /IM chrome.exe /F";
            	}
             else if (command.equalsIgnoreCase("new tab")) {
                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe \\c";
            } 
            else if (command.equalsIgnoreCase("project")) {
                work = "D:\\Depot\\Enterprise\\8.0\\PointOfSale\\ToolsSolution\\bin\\Debug\\Shortcuts.exe";
            }
            else if (command.equalsIgnoreCase("close project")) {
                work = "Taskkill /IM Shortcuts.exe /F";
            }
            else if (command.equalsIgnoreCase("open")) {
                work = "cmd";
            }
            else if (command.equalsIgnoreCase("close open")) {
                work = "Taskkill /IM cmd.exe /F";
            }
            else if (command.equalsIgnoreCase("plus")) {
                work = "calc";
            }
            else if (command.equalsIgnoreCase("close plus")) {
                work = "Taskkill /IM calc.exe /F";
            }
            else if (command.equalsIgnoreCase("paint")) {
                work = "mspaint";
            }
            else if (command.equalsIgnoreCase("close paint")) {
                work = "Taskkill /IM mspaint.exe /F";
            }
            else if (command.equalsIgnoreCase("task manager")) {
                work = "taskmgr.exe";
            }
            else if (command.equalsIgnoreCase("close task manager")) {
                work = "Taskkill /IM taskmgr.exe /F";
            }
            else if (command.equalsIgnoreCase("pdf")) {
                work = "C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32.exe";
            }
            else if (command.equalsIgnoreCase("close pdf")) {
                work = "Taskkill /IM AcroRd32.exe /F";
            }
            else if (command.equalsIgnoreCase("pad")) {
                work = "notepad.exe";
            }
            else if (command.equalsIgnoreCase("close pad")) {
                work = "Taskkill /IM notepad.exe /F";
            }
            else if (command.equalsIgnoreCase("word")) {
                work = "C:\\Program Files (x86)\\Microsoft Office\\Office14\\WINWORD.EXE";
            }
            else if (command.equalsIgnoreCase("close word")) {
                work = "Taskkill /IM WINWORD.EXE /F";
            }
            else if (command.equalsIgnoreCase("ex")) {
                work = "C:\\Program Files (x86)\\Microsoft Office\\Office14\\EXCEL.EXE";
            }
            else if (command.equalsIgnoreCase("close ex")) {
                work = "Taskkill /IM EXCEL.EXE /F";
            }
            else if (command.equalsIgnoreCase("mail")) {
                work = "C:\\Program Files (x86)\\Microsoft Office\\Office14\\OUTLOOK.EXE";
            }
            else if (command.equalsIgnoreCase("close mail")) {
                work = "Taskkill /IM OUTLOOK.EXE /F";
            }
            else if (command.equalsIgnoreCase("youtube")) {
                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe www.youtube.com";
            }
            else if (command.equalsIgnoreCase("facebook")) {
                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe www.facebook.com";
            }
            else if (command.equalsIgnoreCase("skype")) {
                work = "C:\\Program Files (x86)\\Skype\\Phone\\Skype.exe";
            }
            else if (command.equalsIgnoreCase("close skype")) {
                work = "Taskkill /IM Skype.exe /F";
            }
            else if (command.equalsIgnoreCase("vm")) {
                work = "C:\\Program Files\\Oracle\\VirtualBox\\VirtualBox.exe";
            }
            else if (command.equalsIgnoreCase("project")) {
                work = "D:\\Depot\\Enterprise\\8.0\\PointOfSale\\ToolsSolution\\bin\\Debug\\Shortcuts.exe";
            }
            else if (command.equalsIgnoreCase("close project")) {
                work = "Taskkill /IM Shortcuts.exe /F";
            }
            else if (command.equalsIgnoreCase("ols")) {
                work = "D:\\Depot\\Enterprise\\8.0\\PointOfSale\\ToolsSolution\\bin\\Debug\\OnlineServicesAgent.exe";
            }
            else if (command.equalsIgnoreCase("close ols")) {
                work = "Taskkill /IM OnlineServicesAgent.exe /F";
            }
            else if (command.equalsIgnoreCase("service manager")) {
                work = "D:\\Depot\\Enterprise\\8.0\\PointOfSale\\ToolsSolution\\bin\\Debug\\PointOfSaleServiceManager.exe";
            }
            else if (command.equalsIgnoreCase("close service manager")) {
                work = "Taskkill /IM PointOfSaleServiceManager.exe /F";
            }
            else if (command.equalsIgnoreCase("admin")) {
                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe admin.shortcutssoftware.com/console";
            }
            else if (command.equalsIgnoreCase("tn")) {
                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://console.shortcutssoftware.com/";
            }
            //In case command recognized is none of the above hence work might be null
            if(work != null) {
                //Execute the command
                p = Runtime.getRuntime().exec(work);
            }
        }

	}

}
