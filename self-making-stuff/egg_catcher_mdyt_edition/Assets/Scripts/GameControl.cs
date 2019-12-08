using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameControl : MonoBehaviour
{
    public static GameControl instance;          
    private int score = 0;
    private int count = 0;

    public Text scoreText;
    public Text countText;
    public bool gameOver = false;
    public Sprite[] sprites;

    private AudioSource audio;

    void Awake()
    {
        if (instance == null)
            instance = this;
        else if (instance != this)
            Destroy(gameObject);
    }

    void Update()
    {
        if (gameOver && Input.GetMouseButtonDown(0))
        {
            SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
        }
    }

    public void BirdCount()
    {
        countText.text = "Count: " + (++count).ToString();

        if (count == 45)
        {
            gameOver = true;
        }

        if (count != 0 && count % 5 == 0)
        {
            Egg.spawnRateMin *= 0.75f;
            Egg.spawnRateMax *= 0.75f;
            Egg.gravityScaleMin *= 1.2f;
            Egg.gravityScaleMax *= 1.2f;
        }
    }

    public void BirdScored()
    {
        scoreText.text = "Score: " + (++score).ToString();
    }

    public void BirdDied()
    {
        gameOver = true;
    }
}