import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

public class SistemaPremiumSeguranca extends JFrame {

    private JPasswordField senhaP, senhaQ, senhaR;
    private JTextArea logsArea;
    private JProgressBar loadingBar;
    private JLabel statusLabel;

    public SistemaPremiumSeguranca() {
        configurarJanela();
        criarInterface();
        simularInicializacao();
    }

    private void configurarJanela() {
        setTitle("Sistema Premium de Segurança");
        setSize(1400, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(5, 10, 25));
    }

    private void criarInterface() {
        add(criarHeader(), BorderLayout.NORTH);
        add(criarCentro(), BorderLayout.CENTER);
        add(criarFooter(), BorderLayout.SOUTH);
    }

    private JPanel criarHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(3, 8, 20));
        header.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("SISTEMA PREMIUM DE SEGURANÇA", SwingConstants.CENTER);
        titulo.setForeground(new Color(0, 170, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));

        JLabel subtitulo = new JLabel("Inicializando sistema...", SwingConstants.CENTER);
        subtitulo.setForeground(Color.WHITE);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel tituloPanel = new JPanel(new GridLayout(2, 1));
        tituloPanel.setOpaque(false);
        tituloPanel.add(titulo);
        tituloPanel.add(subtitulo);

        loadingBar = new JProgressBar(0, 100);
        loadingBar.setPreferredSize(new Dimension(500, 10));
        loadingBar.setForeground(new Color(0, 150, 255));
        loadingBar.setBackground(new Color(20, 20, 20));
        loadingBar.setBorderPainted(false);

        JPanel progressoPanel = new JPanel();
        progressoPanel.setOpaque(false);
        progressoPanel.add(loadingBar);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.add(tituloPanel, BorderLayout.CENTER);
        wrapper.add(progressoPanel, BorderLayout.SOUTH);

        header.add(wrapper, BorderLayout.CENTER);

        return header;
    }

    private JPanel criarCentro() {
        JPanel centro = new JPanel(new GridLayout(1, 2, 20, 20));
        centro.setBackground(new Color(5, 10, 25));
        centro.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        centro.add(criarPainelAutenticacao());
        centro.add(criarPainelLogs());

        return centro;
    }

    private JPanel criarPainelAutenticacao() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        painel.setBackground(new Color(8, 15, 35));
        painel.setBorder(new LineBorder(new Color(0, 120, 255), 1, true));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = new JLabel("AUTENTICAÇÃO DE ACESSO");
        titulo.setForeground(new Color(0, 170, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 26));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painel.add(titulo, gbc);

        senhaP = criarCampoSenha();
        senhaQ = criarCampoSenha();
        senhaR = criarCampoSenha();

        adicionarCampo(painel, gbc, "Senha P:", senhaP, 1);
        adicionarCampo(painel, gbc, "Senha Q:", senhaQ, 2);
        adicionarCampo(painel, gbc, "Senha Extra R:", senhaR, 3);

        JButton verificar = new JButton("VERIFICAR ACESSO");
        verificar.setBackground(new Color(0, 90, 255));
        verificar.setForeground(Color.WHITE);
        verificar.setFont(new Font("Arial", Font.BOLD, 22));
        verificar.setFocusPainted(false);
        verificar.setPreferredSize(new Dimension(300, 60));
        verificar.setBorder(new LineBorder(new Color(0, 170, 255), 1, true));

        verificar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                verificar.setBackground(new Color(0, 140, 255));
            }
            public void mouseExited(MouseEvent e) {
                verificar.setBackground(new Color(0, 90, 255));
            }
        });

        verificar.addActionListener(e -> verificarAcesso());

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        painel.add(verificar, gbc);

        return painel;
    }

    private JPanel criarPainelLogs() {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(new Color(8, 15, 35));
        painel.setBorder(new LineBorder(new Color(0, 255, 100), 1, true));

        JLabel titulo = new JLabel("LOGS DO SISTEMA");
        titulo.setForeground(new Color(0, 255, 100));
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        logsArea = new JTextArea();
        logsArea.setEditable(false);
        logsArea.setBackground(new Color(3, 8, 20));
        logsArea.setForeground(new Color(0, 255, 100));
        logsArea.setFont(new Font("Consolas", Font.PLAIN, 20));

        JScrollPane scroll = new JScrollPane(logsArea);
        scroll.setBorder(null);

        JButton limpar = new JButton("LIMPAR LOGS");
        limpar.setBackground(new Color(20, 20, 20));
        limpar.setForeground(Color.WHITE);
        limpar.addActionListener(e -> logsArea.setText(""));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(titulo, BorderLayout.WEST);
        top.add(limpar, BorderLayout.EAST);

        painel.add(top, BorderLayout.NORTH);
        painel.add(scroll, BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(3, 8, 20));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel protegido = new JLabel("Sistema protegido e monitorado");
        protegido.setForeground(Color.LIGHT_GRAY);

        statusLabel = new JLabel("● ONLINE");
        statusLabel.setForeground(Color.GREEN);

        JLabel hora = new JLabel(LocalTime.now().withNano(0).toString());
        hora.setForeground(Color.WHITE);

        footer.add(protegido, BorderLayout.WEST);
        footer.add(statusLabel, BorderLayout.CENTER);
        footer.add(hora, BorderLayout.EAST);

        return footer;
    }

    private JPasswordField criarCampoSenha() {
        JPasswordField campo = new JPasswordField();
        campo.setPreferredSize(new Dimension(350, 45));
        campo.setBackground(new Color(5, 10, 25));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.CYAN);
        campo.setBorder(new LineBorder(new Color(0, 120, 255), 1, true));
        return campo;
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints gbc, String texto, JPasswordField campo, int linha) {
        JLabel label = new JLabel(texto);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridy = linha;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        painel.add(label, gbc);

        gbc.gridx = 1;
        painel.add(campo, gbc);
    }

    private void simularInicializacao() {
        Timer timer = new Timer(40, null);
        timer.addActionListener(new ActionListener() {
            int progresso = 0;

            public void actionPerformed(ActionEvent e) {
                progresso++;
                loadingBar.setValue(progresso);

                if (progresso == 20) adicionarLog("Sistema iniciado com sucesso.");
                if (progresso == 45) adicionarLog("Carregando módulos de segurança...");
                if (progresso == 70) adicionarLog("Conectando aos serviços...");
                if (progresso == 100) {
                    adicionarLog("Sistema pronto para uso.");
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    private void verificarAcesso() {
        String p = new String(senhaP.getPassword());
        String q = new String(senhaQ.getPassword());
        String r = new String(senhaR.getPassword());

        if ((p.equals("123") && q.equals("abc")) || r.equals("extra")) {
            adicionarLog("SUCESSO: Acesso liberado com sucesso.");
            statusLabel.setText("● ACESSO AUTORIZADO");
            statusLabel.setForeground(Color.GREEN);
        } else {
            adicionarLog("ERRO: Tentativa de acesso inválida.");
            statusLabel.setText("● ACESSO NEGADO");
            statusLabel.setForeground(Color.RED);
        }
    }

    private void adicionarLog(String mensagem) {
        logsArea.append("[" + LocalTime.now().withNano(0) + "] " + mensagem + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaPremiumSeguranca().setVisible(true));
    }
}

