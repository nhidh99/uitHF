using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameControl : MonoBehaviour
{
    public static GameControl instance;          
    public Text scoreText;
    public AudioSource audio;

    private int score = 0;
    public bool birdScore = false;
    public bool gameStart = false;
    public bool gameOver = false;                
    public float scrollSpeed = -4.0f;

    void Awake()
    {
        if (instance == null)
            instance = this;
        else if (instance != this)
            Destroy(gameObject);
        audio = GetComponent<AudioSource>();
    }

    void Update()
    {
        if (!gameStart && Input.GetMouseButtonDown(0))
        {
            Bird.instance.SetGravityScale(1.0f);
            gameStart = true;
        }

        if (gameOver && Input.GetMouseButtonDown(0))
        {
            SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
        }
    }

    public void BirdScored()
    {
        if (gameOver)
            return;
        audio.Play();
        scoreText.text = "Score: " + (++score).ToString();
    }

    public void BirdDied()
    {
        gameOver = true;
    }
}