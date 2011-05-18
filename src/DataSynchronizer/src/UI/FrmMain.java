package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.DebugGraphics;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import DataSynchronizer.DataSync;

import com.palm.novacom.INovacomController;
import com.palm.novacom.INovacomDevice;
import com.palm.novacom.Novacom;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FrmMain extends javax.swing.JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1882661021449982401L;

    private JCheckBox         cbMedia_;
    private JCheckBox         cbJava_;
    private JButton           btnSelectAll_;
    private JButton           btnPathDialog_;
    private JButton           btnDeSelectAll;
    private JFileChooser      dlgGetPath_;
    private JButton           btnAcquire_;
    private JTextField        txtBackupPath_;
    private JCheckBox         cbApp_;
    private JCheckBox         cbDataBase_;

    private OptionsManager    options_         = null;

    {
        // Set Look & Feel
        try
        {
            String value = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            javax.swing.UIManager.setLookAndFeel(value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                OptionsManager options = new OptionsManager();
                FrmMain inst = new FrmMain(options);
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public FrmMain()
    {
        super();
        initGUI();
    }

    public FrmMain(OptionsManager options)
    {
        super();
        options_ = options;
        initGUI();
    }

    private void initGUI()
    {
        try
        {
            GridBagLayout thisLayout = new GridBagLayout();
            thisLayout.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1 };
            thisLayout.rowHeights = new int[] { 7, 7, 7, 7 };
            thisLayout.columnWeights = new double[] { 0.1, 0.1, 0.1 };
            thisLayout.columnWidths = new int[] { 7, 7, 7, 7 };
            getContentPane().setLayout(thisLayout);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                cbMedia_ = new JCheckBox();
                getContentPane().add(
                        cbMedia_,
                        new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                cbMedia_.setText("Media");
                cbMedia_.setOpaque(false);
                cbMedia_.setFont(new java.awt.Font("Tahoma", 0, 14));
                cbMedia_.addItemListener(new ItemListener()
                {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        cbMedia_ItemStateChanged(evt);
                    }
                });
            }
            {
                cbJava_ = new JCheckBox();
                getContentPane().add(
                        cbJava_,
                        new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                cbJava_.setText("Java services");
                cbJava_.setFont(new java.awt.Font("Tahoma", 0, 14));
                cbJava_.addItemListener(new ItemListener()
                {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        cbJava_ItemStateChanged(evt);
                    }
                });
            }
            {
                cbDataBase_ = new JCheckBox();
                getContentPane().add(
                        cbDataBase_,
                        new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                cbDataBase_.setText("Databases, mail");
                cbDataBase_.setFont(new java.awt.Font("Tahoma", 0, 14));
                cbDataBase_.addItemListener(new ItemListener()
                {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        cbDataBase_ItemStateChanged(evt);
                    }
                });
            }
            {
                cbApp_ = new JCheckBox();
                getContentPane().add(
                        cbApp_,
                        new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                cbApp_.setText("Web applications");
                cbApp_.setFont(new java.awt.Font("Tahoma", 0, 14));
                cbApp_.addItemListener(new ItemListener()
                {
                    public void itemStateChanged(ItemEvent evt)
                    {
                        cbApp_ItemStateChanged(evt);
                    }
                });
            }
            {
                btnSelectAll_ = new JButton();
                GridLayout btnSelectAll_Layout = new GridLayout(1, 1);
                btnSelectAll_Layout.setColumns(1);
                btnSelectAll_Layout.setHgap(5);
                btnSelectAll_Layout.setVgap(5);
                btnSelectAll_.setLayout(btnSelectAll_Layout);
                getContentPane().add(
                        btnSelectAll_,
                        new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                                GridBagConstraints.NORTH,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                btnSelectAll_.setText("Select All");
                btnSelectAll_.setFont(new java.awt.Font("Tahoma", 0, 14));
                btnSelectAll_.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        btnSelectAll_ActionPerformed(evt);
                    }
                });
            }
            {
                txtBackupPath_ = new JTextField();
                getContentPane().add(
                        txtBackupPath_,
                        new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.EAST,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                txtBackupPath_.setText("Enter backup path here");
                txtBackupPath_.setFont(new java.awt.Font("Tahoma", 0, 14));
                txtBackupPath_.addFocusListener(new FocusAdapter()
                {
                    public void focusLost(FocusEvent evt)
                    {
                        txtBackupPath_FocusLost(evt);
                    }
                });
            }
            {
                btnPathDialog_ = new JButton();
                getContentPane().add(
                        btnPathDialog_,
                        new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 1,
                                        0, 0), 0, 0));
                btnPathDialog_.setText("..");
                btnPathDialog_.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        btnPathDialog_ActionPerformed(evt);
                    }
                });
            }
            {
                btnAcquire_ = new JButton();
                getContentPane().add(
                        btnAcquire_,
                        new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER,
                                GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                btnAcquire_.setText("Acuire");
                btnAcquire_.setFont(new java.awt.Font("Tahoma", 0, 14));
                btnAcquire_.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        btnAcquire_ActionPerformed(evt);
                    }
                });
            }
            {
                btnDeSelectAll = new JButton();
                getContentPane().add(
                        btnDeSelectAll,
                        new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                                GridBagConstraints.SOUTH,
                                GridBagConstraints.HORIZONTAL, new Insets(0, 0,
                                        0, 0), 0, 0));
                btnDeSelectAll.setText("Deselect All");
                btnDeSelectAll.setFont(new java.awt.Font("Tahoma", 0, 14));
                btnDeSelectAll.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                        btnDeSelectAllActionPerformed(evt);
                    }
                });
            }
            pack();
            this.setSize(350, 230);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void btnPathDialog_ActionPerformed(ActionEvent evt)
    {
        //System.out.println("btnPathDialog_.actionPerformed, event=" + evt);
        
        
        JFileChooser dialog = getDlgGetPath();
        int dialogResult = dialog.showOpenDialog(this);
        
        if (dialogResult == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = dialog.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            
            path = EnsureCorrectPathFormat(path);
            txtBackupPath_.setText(path);
            
            
            UpdateBackupPath();
        }
    }

    private String EnsureCorrectPathFormat(String path)
    {
        path = path.replace("\\", "/");
        if (false == path.endsWith("/"))
        {
            path = path + "/";    
        }
        return path;
    }

    private void btnAcquire_ActionPerformed(ActionEvent evt)
    {
        //System.out.println("btnAcquire_.actionPerformed, event=" + evt);

        try
        {
            System.out.println("Connecting to device...");
            INovacomController controller = Novacom.getController();
            INovacomDevice device;

            device = controller.connectDefaultDevice();
            System.out.println("Connected to device successfully.");

            String backupPath = options_.GetBackupPath();

            System.out.println("Acquiring filesystem...");
            DataSync sync = new DataSync(options_, device, backupPath);
            sync.Acquire();

            JOptionPane.showMessageDialog(this, "Data acquisition ended successfully.");
            
            System.out.println("Acquiring filesystem finished.");
        }
        catch (Exception e)
        {
            System.out.println("Acquisition failed.");
            e.printStackTrace();
        }
    }

    private void btnDeSelectAllActionPerformed(ActionEvent evt)
    {
        cbMedia_.setSelected(false);
        cbJava_.setSelected(false);
        cbApp_.setSelected(false);
        cbDataBase_.setSelected(false);
    }

    private void btnSelectAll_ActionPerformed(ActionEvent evt)
    {
        cbMedia_.setSelected(true);
        cbJava_.setSelected(true);
        cbApp_.setSelected(true);
        cbDataBase_.setSelected(true);
    }

    private void txtBackupPath_FocusLost(FocusEvent evt)
    {
       // System.out.println("txtBackupPath_.focusLost, event=" + evt);
        
        
        String userInput = txtBackupPath_.getText();
        String newValue = EnsureCorrectPathFormat(userInput);
        txtBackupPath_.setText(newValue);
        
        UpdateBackupPath();
    }

    private void UpdateBackupPath()
    {
        String value = txtBackupPath_.getText();
        options_.SetBackupPath(value);
    }

    private void cbMedia_ItemStateChanged(ItemEvent evt)
    {
        //System.out.println("cbMedia_.itemStateChanged, event=" + evt);

        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            options_.SetAcquireMedia(true);
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED)
        {
            options_.SetAcquireMedia(false);
        }
        else
        {
            // Ignore
        }
    }

    private void cbDataBase_ItemStateChanged(ItemEvent evt)
    {
        //System.out.println("cbDataBase_.itemStateChanged, event=" + evt);

        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            options_.SetAcquireDataBase(true);
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED)
        {
            options_.SetAcquireDataBase(false);
        }
        else
        {
            // Ignore
        }
    }

    private void cbJava_ItemStateChanged(ItemEvent evt)
    {
        //System.out.println("cbJava_.itemStateChanged, event=" + evt);

        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            options_.SetAcquireJava(true);
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED)
        {
            options_.SetAcquireJava(false);
        }
        else
        {
            // Ignore
        }
    }

    private void cbApp_ItemStateChanged(ItemEvent evt)
    {
        //System.out.println("cbApp_.itemStateChanged, event=" + evt);

        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            options_.SetAcquireApplication(true);
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED)
        {
            options_.SetAcquireApplication(false);
        }
        else
        {
            // Ignore
        }
    }
    
    private JFileChooser getDlgGetPath() 
    {
        if(dlgGetPath_ == null) 
        {
            dlgGetPath_ = new JFileChooser();
            dlgGetPath_.setEnabled(false);
            dlgGetPath_.setFont(new java.awt.Font("Arial",0,14));
            dlgGetPath_.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
            dlgGetPath_.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        
        return dlgGetPath_;
    }
    
}
