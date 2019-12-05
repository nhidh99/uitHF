using UnityEngine;
using System.Collections;

public class ColumnPool : MonoBehaviour
{
    public GameObject columnPrefab;                                   
    public int columnPoolSize = 5;                                  
    public static float spawnRateMin = 2.5f;
    public static float spawnRateMax = 5f;         
    public float spawnYPosition = -4.0f;
    private float spawnRate = 4f;              

    private Column[] columns;                                  
    private int currentColumn = 0;                               

    private Vector2 objectPoolPosition = new Vector2(-15, -25);    
    private float spawnXPosition = 20f;

    private float timeSinceLastSpawned;


    void Start()
    {
        timeSinceLastSpawned = 0f;
        columns = new Column[columnPoolSize];
        for (int i = 0; i < columnPoolSize; i++)
        {
            GameObject obj = (GameObject)Instantiate(columnPrefab, objectPoolPosition, Quaternion.identity);
            columns[i] = obj.GetComponent<Column>();
        }
    }

    void Update()
    {
        timeSinceLastSpawned += Time.deltaTime;

        if (timeSinceLastSpawned >= spawnRate)
        {
            spawnRate = Random.Range(spawnRateMin, spawnRateMax);
            timeSinceLastSpawned = 0f;

            Sprite[] sprites = GameControl.instance.sprites;
            int spriteIndex = Random.Range(0, sprites.Length);
            Sprite sprite = sprites[spriteIndex];

            columns[currentColumn].changeSprite(sprite);
            columns[currentColumn].transform.position = new Vector2(spawnXPosition, spawnYPosition);

            if (++currentColumn >= columnPoolSize)
            {
                currentColumn = 0;
            }
        }
    }
}