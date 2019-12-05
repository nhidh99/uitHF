using UnityEngine;
using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameControl : MonoBehaviour
{
    public static GameControl instance;          
    public Text scoreText;                       

    private int score = 0;                       
    public bool gameOver = false;                
    public float scrollSpeed = -5.0f;

    public Sprite[] sprites;

    public List<ScrollingObject> scrollingObjs = new List<ScrollingObject>();

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

    public void BirdScored()
    {
        if (gameOver)
            return;
        scoreText.text = "Score: " + (++score).ToString();

        if (score % 5 == 0)
        {
            scrollSpeed *= 1.1f;
            ColumnPool.spawnRateMin *= 0.9f;
            ColumnPool.spawnRateMax *= 0.9f;

            foreach (ScrollingObject obj in scrollingObjs)
            {
                obj.setVelocity(new Vector2(scrollSpeed, 0));
            }
        }
    }

    public void BirdDied()
    {
        gameOver = true;
    }
}